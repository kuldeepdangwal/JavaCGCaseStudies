package com.cg.payroll.client;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;

public class MainClass {
	public static void main(String[] args) {
			PayrollServices services = new PayrollServicesImpl();
			Scanner sc = new Scanner(System.in);	
			System.out.println("******************PAYROLL SYSTEM********************");
			char ch='y';
			while(ch=='y'||ch=='Y') {
				System.out.println("Enter your choice:\n1. Save Associate\n2. Calculate Net Salary\n3. Get Associate Details"
						+ "\n4. Get All Associate Details");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					int associateId=services.acceptAssociateDetails("Kuldeep", "Dangwal", "kuldeepd@gmail.com", "RTF", "A4", "CHD9876", 80000, 30000, 1000, 1500, 5896642, "Citi", "citi0001");
					System.out.println("Associate Id: "+associateId);
					break;
				case 2:
					System.out.println("Enter associate id to calculate net salary: ");
					int id = sc.nextInt();
					int netSalary = services.calculateNetSalary(id);
					System.out.println("Net Salary = "+netSalary);
					break;
				case 3: 
					System.out.println("Enter associate id to find details: ");
					id = sc.nextInt();
					Associate associateDetails = services.getAssociateDetails(id);
					System.out.println(associateDetails);
					break;
				case 4:
					List<Associate> allAssociateDetails = services.getAllAssociatesDetails();		
					System.out.println(allAssociateDetails);
					break;
			default:
				System.out.println("Please enter a valid number");
				break;
			}
				System.out.println("Do you want to continue(y/n): ");
				ch = sc.next().charAt(0);
			}
	}
}
