package com.cg.payroll.payrollservices;

import java.util.List;
import com.cg.payroll.beans.*;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
public interface PayrollServices {
	int acceptAssociatedetails(String firstName,String lastName,int yearlyInvestmentUnder80C,String department,String designation,String pancard,String emailId,int basicPay,int epf,int pf,int accountNo,String ifsc,String bankName);
	
	int calculateNetSalary(int associateId) throws AssociateDetailsNotFoundException;
	
	Associate getAssociateDetails(int associateId) throws AssociateDetailsNotFoundException;
	
	List<Associate> getAllAssociatesDetails();
}
