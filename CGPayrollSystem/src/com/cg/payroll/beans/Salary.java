package com.cg.payroll.beans;

import java.io.Serializable;
public class Salary implements Serializable{
	private int basicPay,hra,conveyanceAllowance,otherAllowance,personalAllowance,monthlyTax,epf,companyPf,gratuity,grossSalary,netSalary;

	public Salary() {
		super();
	}

	public Salary(int basicPay, int epf, int companyPf) {
		super();
		this.basicPay = basicPay;
		this.epf = epf;
		this.companyPf = companyPf;
	}

	public Salary(int basicPay, int hra, int conveyanceAllowance, int otherAllowance, int personalAllowance,
			int monthlyTax, int epf, int companyPf, int gratuity, int grossSalary, int netSalary) {
		super();
		this.basicPay = basicPay;
		this.hra = hra;
		this.conveyanceAllowance = conveyanceAllowance;
		this.otherAllowance = otherAllowance;
		this.personalAllowance = personalAllowance;
		this.monthlyTax = monthlyTax;
		this.epf = epf;
		this.companyPf = companyPf;
		this.gratuity = gratuity;
		this.grossSalary = grossSalary;
		this.netSalary = netSalary;
	}

	public int getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(int basicPay) {
		this.basicPay = basicPay;
	}

	public int getHra() {
		return hra;
	}

	public void setHra(int hra) {
		this.hra = hra;
	}

	public int getConveyanceAllowance() {
		return conveyanceAllowance;
	}

	public void setConveyanceAllowance(int conveyanceAllowance) {
		this.conveyanceAllowance = conveyanceAllowance;
	}

	public int getOtherAllowance() {
		return otherAllowance;
	}

	public void setOtherAllowance(int otherAllowance) {
		this.otherAllowance = otherAllowance;
	}

	public int getPersonalAllowance() {
		return personalAllowance;
	}

	public void setPersonalAllowance(int personalAllowance) {
		this.personalAllowance = personalAllowance;
	}

	public int getMonthlyTax() {
		return monthlyTax;
	}

	public void setMonthlyTax(int monthlyTax) {
		this.monthlyTax = monthlyTax;
	}

	public int getEpf() {
		return epf;
	}

	public void setEpf(int epf) {
		this.epf = epf;
	}

	public int getCompanyPf() {
		return companyPf;
	}

	public void setCompanyPf(int companyPf) {
		this.companyPf = companyPf;
	}

	public int getGratuity() {
		return gratuity;
	}

	public void setGratuity(int gratuity) {
		this.gratuity = gratuity;
	}

	public int getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(int grossSalary) {
		this.grossSalary = grossSalary;
	}

	public int getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(int netSalary) {
		this.netSalary = netSalary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + basicPay;
		result = prime * result + companyPf;
		result = prime * result + conveyanceAllowance;
		result = prime * result + epf;
		result = prime * result + gratuity;
		result = prime * result + grossSalary;
		result = prime * result + hra;
		result = prime * result + monthlyTax;
		result = prime * result + netSalary;
		result = prime * result + otherAllowance;
		result = prime * result + personalAllowance;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salary other = (Salary) obj;
		if (basicPay != other.basicPay)
			return false;
		if (companyPf != other.companyPf)
			return false;
		if (conveyanceAllowance != other.conveyanceAllowance)
			return false;
		if (epf != other.epf)
			return false;
		if (gratuity != other.gratuity)
			return false;
		if (grossSalary != other.grossSalary)
			return false;
		if (hra != other.hra)
			return false;
		if (monthlyTax != other.monthlyTax)
			return false;
		if (netSalary != other.netSalary)
			return false;
		if (otherAllowance != other.otherAllowance)
			return false;
		if (personalAllowance != other.personalAllowance)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Salary [basicPay=" + basicPay + ", hra=" + hra + ", conveyanceAllowance=" + conveyanceAllowance
				+ ", otherAllowance=" + otherAllowance + ", personalAllowance=" + personalAllowance + ", monthlyTax="
				+ monthlyTax + ", epf=" + epf + ", companyPf=" + companyPf + ", gratuity=" + gratuity + ", grossSalary="
				+ grossSalary + ", netSalary=" + netSalary + "]";
	}

}