package com.cg.payroll.client;
import java.util.Scanner;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.payrollservices.PayrollServices;
import com.cg.payroll.payrollservices.PayrollServicesImpl;
public class MainClass {
	public static void main(String[] args) throws AssociateDetailsNotFoundException {
		String firstName,lastName,department,designation,emailId,panCardNumber,IFSC,bankName;
		int yearlyInvestmentUnder80C,basicSalary,ePf,companyPf,accountNo,ch=0;
		Scanner	scanner = new Scanner(System.in);
		PayrollServices payrollServices = new PayrollServicesImpl();
		do {
			System.out.println("--------------------------------------");
			System.out.println("1.Add associate.\n 2.Display Associate Details.\n3.Display Net Monthly Salary.\n4.Exit");
			System.out.println("--------------------------------------");
			System.out.println("Enter your choice.");
			ch = scanner.nextInt();
			scanner.nextLine();
			switch (ch) {
			case 1:System.out.print("Enter Associate Details : ");
						System.out.print("\nEnter First name : ");
						firstName = scanner.nextLine();
						System.out.print("Enter Last name : ");
						lastName = scanner.nextLine();
						System.out.print("Enter Yearly Investment : ");
						yearlyInvestmentUnder80C = scanner.nextInt();
						scanner.nextLine();
						System.out.print("Enter Department : ");
						department = scanner.nextLine();
						System.out.print("Enter Designation : ");
						designation = scanner.nextLine();
						System.out.print("Enter Pancard no : ");
						panCardNumber = scanner.nextLine();
						System.out.print("Enter Email Id : ");
						emailId = scanner.nextLine();
						System.out.print("Enter Basic Salary : ");
						basicSalary = scanner.nextInt();
						System.out.print("Enter EPF : ");
						ePf = scanner.nextInt();
						System.out.print("Enter Company PF : ");
						companyPf = scanner.nextInt();
						System.out.print("Enter A/c No : ");
						accountNo = scanner.nextInt();
						scanner.nextLine();
						System.out.print("Enter Ifsc code : ");
						IFSC = scanner.nextLine();
						System.out.print("Enter Bank Name : ");
						bankName = scanner.nextLine();
						System.out.println("Associate registered Successfully.");
						int associateId=payrollServices.acceptAssociatedetails(firstName, lastName, yearlyInvestmentUnder80C, department, designation, panCardNumber, emailId, basicSalary, ePf, companyPf, accountNo, IFSC, bankName); 
						System.out.println("Associate id : "+associateId);
						break;
			case 2:
						System.out.print("Enter Associate Id : ");
						associateId = scanner.nextInt();
						System.out.println("Associate Details are following :- ");
						System.out.println(payrollServices.getAssociateDetails(associateId).toString());
						break;
			case 3:
						System.out.print("Enter Associate Id : ");
						associateId = scanner.nextInt();
						System.out.println("Salary is : "+payrollServices.calculateNetSalary(associateId));
						break;
			case 4:
						System.out.println("Thanks.........Exiting now.");
						System.exit(0);
			default:
						System.out.println("Not A Valid Choice.");
						break;
			}
		}while(ch !=4);
		/*try {
			//PayrollServices payrollServices = new PayrollServicesImpl();
			//int associateId = payrollServices.acceptAssociatedetails("tanuj", "kumar", 5000, "developer", "Analyst", "adb123", "tanuj@gmail.com", 50000, 1000, 1000, 111, "icici2123", "ICICI");
			System.out.println("Associate id : "+associateId);
			System.out.println(payrollServices.getAssociateDetails(associateId));	
			System.out.println(payrollServices.calculateNetSalary(associateId));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
}