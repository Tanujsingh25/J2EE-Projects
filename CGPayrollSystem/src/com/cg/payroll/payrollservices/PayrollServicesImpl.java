package com.cg.payroll.payrollservices;

import java.util.List;

import com.cg.payroll.beans.*;
import com.cg.payroll.daoservices.AssociateDAO;
import com.cg.payroll.daoservices.AssociateDAOImpl;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
public class PayrollServicesImpl implements PayrollServices{
	private AssociateDAO associateDAO ;
	public PayrollServicesImpl() {
		associateDAO = new AssociateDAOImpl();
	}
	public PayrollServicesImpl(AssociateDAO associateDAO) {
		super();
		this.associateDAO = associateDAO;
	}
	@Override
	public int calculateNetSalary(int associateId) throws AssociateDetailsNotFoundException {
		int monthlyTax,taxableAmount;
		Associate associate = this.getAssociateDetails(associateId);
		int basicSalary = associate.getSalary().getBasicPay();
		int hra = basicSalary *40/100;
		int conveyanceAllowance = basicSalary * 30/100;
		int otherAllowance = basicSalary * 20/100;
		int personalAllowance = basicSalary * 20/100;
		int epf = associate.getSalary().getEpf();
		int companyPf = associate.getSalary().getCompanyPf();
		int grossSalary = basicSalary+hra+conveyanceAllowance+otherAllowance+personalAllowance+epf+companyPf;
		int annualSalary = grossSalary*12;
		if(associate.getYearlyInvestmentUnder80C() < 180000) 
			taxableAmount = annualSalary-associate.getYearlyInvestmentUnder80C()-epf*12-companyPf*12;
		else 
			taxableAmount = annualSalary-associate.getSalary().getEpf()*12-associate.getSalary().getCompanyPf()*12-180000;	
		if(annualSalary <= 250000)
			return grossSalary - (epf*12) - (companyPf*12)-associate.getYearlyInvestmentUnder80C();
		
		else if(annualSalary>250000 && annualSalary <= 500000) {
			taxableAmount -= 250000;
			monthlyTax = (taxableAmount /10)/12;
			return grossSalary-monthlyTax-epf-companyPf;
		}
		else if(annualSalary>500000 && annualSalary>1000000) {
			taxableAmount -= 500000;
			monthlyTax = (taxableAmount /5)/12+ 25000;
			return grossSalary- monthlyTax- epf-companyPf;
		}
		else if(annualSalary>1000000) {
			taxableAmount -= 1000000;
			monthlyTax = (taxableAmount /5)/12+ 750000;
			return grossSalary- monthlyTax- epf-companyPf;
		}
		return 0;
	}
	@Override
	public Associate getAssociateDetails(int associateId) throws AssociateDetailsNotFoundException {
		Associate associate = associateDAO.findOne(associateId);
		if(associate == null)
			throw new AssociateDetailsNotFoundException("Associate "+associateId+" is not found in database.");
		return associate;
	}
	@Override
	public List<Associate> getAllAssociatesDetails() {
		return associateDAO.findAll();
	}
	@Override
	public int acceptAssociatedetails(String firstName, String lastName, int yearlyInvestmentUnder80C,String department, String designation, String pancard, String emailId, int basicPay, int epf, int companyPf,	int accountNo, String ifsc, String bankName) {
		Associate associate = new Associate(yearlyInvestmentUnder80C, firstName, lastName, department, designation, pancard, emailId, new Salary(basicPay, epf, companyPf), new BankDetails(accountNo, ifsc, bankName));

		associate = associateDAO.save(associate);
		return associate.getAssociateID();
	}

}
