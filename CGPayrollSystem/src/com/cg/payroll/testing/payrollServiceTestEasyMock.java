package com.cg.payroll.testing;

import java.util.ArrayList;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.AssociateDAO;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.payrollservices.PayrollServices;
import com.cg.payroll.payrollservices.PayrollServicesImpl;

public class payrollServiceTestEasyMock {
	private static PayrollServices payrollServices;
	private static AssociateDAO mockAssociateDao;
	@BeforeClass
	public static void setUpTestEnv() {
		mockAssociateDao = EasyMock.mock(AssociateDAO.class);
		payrollServices = new PayrollServicesImpl(mockAssociateDao);
	}
	@Before
	public void setUpTestMockData() {
		Associate associate1 = new Associate(101,5000,"tanuj", "kumar","developer", "Analyst", "adb123", "tanuj@gmail.com", new Salary( 50000,1000, 1000),new BankDetails(111,"icici2123", "ICICI"));
		Associate associate2 = new Associate(102,7000,"anuj", "singh","devops", "A1", "adb3", "anuj@gmail.com", new Salary( 30000,1000, 2000),new BankDetails(112,"icici2123", "ICICI"));
		Associate associate3 = new Associate(103,4000,"anubhav", "bansal","CRM", "A3", "adb32", "anubhav@gmail.com", new Salary( 40000,2500, 2000),new BankDetails(113,"icici2123", "ICICI"));

		ArrayList<Associate> associateList = new ArrayList<>();
		associateList.add(associate1);
		associateList.add(associate2);

		EasyMock.expect(mockAssociateDao.save(associate3)).andReturn(associate3);
		EasyMock.expect(mockAssociateDao.findOne(101)).andReturn(associate1);
		EasyMock.expect(mockAssociateDao.findOne(102)).andReturn(associate2);
		EasyMock.expect(mockAssociateDao.findOne(12345)).andReturn(null);
	}
	@Test(expected= AssociateDetailsNotFoundException.class)
	public void testGetAssociateDataForInvalidAssociateId() throws AssociateDetailsNotFoundException    {
		payrollServices.getAssociateDetails(12345);
		EasyMock.verify(mockAssociateDao.findOne(12345));
	}
	@Test(expected= AssociateDetailsNotFoundException.class)
	public void testGetAssociateDataForValidAssociateId() throws AssociateDetailsNotFoundException  {
		Associate expectedAssociate= new Associate(101,5000,"tanuj", "kumar","developer", "Analyst", "adb123", "tanuj@gmail.com", new Salary( 50000,1000, 1000),new BankDetails(111,"icici2123", "ICICI"));
		Associate actualAssociate=payrollServices.getAssociateDetails(101);
		EasyMock.verify(mockAssociateDao.findOne(101));
		Assert.assertEquals(expectedAssociate, actualAssociate);
	}
	@After
	public void tearDownTesData() {
		EasyMock.resetToDefault(mockAssociateDao);
	}
	@AfterClass
	public static void tearDownTestEnv()    {
		mockAssociateDao= null;
		payrollServices= null;      
	}
}
