package com.cg.payroll.beans;

import java.io.Serializable;
public class BankDetails implements Serializable {
	private int accountNo;
	private String ifsc,bankName;
	public BankDetails() {
		super();
	}
	public BankDetails(int accountNo, String ifsc, String bankName) {
		super();
		this.accountNo = accountNo;
		this.ifsc = ifsc;
		this.bankName = bankName;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNo;
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((ifsc == null) ? 0 : ifsc.hashCode());
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
		BankDetails other = (BankDetails) obj;
		if (accountNo != other.accountNo)
			return false;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (ifsc == null) {
			if (other.ifsc != null)
				return false;
		} else if (!ifsc.equals(other.ifsc))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BankDetails [accountNo=" + accountNo + ", ifsc=" + ifsc + ", bankName=" + bankName + "]";
	}

}
