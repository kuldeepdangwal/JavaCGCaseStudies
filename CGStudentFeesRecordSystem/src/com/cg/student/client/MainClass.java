package com.cg.student.client;

import java.util.List;
import java.util.Scanner;

import com.cg.student.beans.Fees;
import com.cg.student.beans.Student;
import com.cg.student.services.StudentServices;
import com.cg.student.services.StudentServicesImpl;

public class MainClass {

	public static void main(String[] args) {
		StudentServices services = new StudentServicesImpl();
		Fees fees = new Fees();
		Scanner sc = new Scanner(System.in);	
		System.out.println("******************Student Fees System********************");
		char ch='y';
		boolean transportStatus;
		while(ch=='y'||ch=='Y') {
			System.out.println("Enter your choice:\n1. Save Student\n2. Calculate Total Fess\n3. Get Student Details"
					+ "\n4. Get All Student Details");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Student Name : ");
				String studentName = sc.next();
				System.out.println("Enter Student Address : ");
				String studentAddress = sc.next();
				System.out.println("Enter Student Contact Number : ");
				long contactNumber = sc.nextLong();
				System.out.println("Enter Student Class : ");
				String studentClass = sc.next();
				System.out.println("Want to opt for transport:\n1. Yes\n2. No ");
				int option=sc.nextInt();
					if(option==1)
						transportStatus=true;
					else
						transportStatus=false;
				System.out.println("Enter Tution Fees : ");
				int tutionFees=sc.nextInt();
				System.out.println("Enter Examination Fees : ");
				int examinationFees=sc.nextInt();
				int studentId = services.acceptStudentDetails(studentName, studentAddress, contactNumber, studentClass, transportStatus, tutionFees, examinationFees);
				System.out.println("Student Added with student Id : "+studentId);
				break;
			case 2:
				System.out.println("Enter student id to calculate total fees : ");
				studentId = sc.nextInt();
				int totalFees = services.calculateTotalFees(studentId);
				System.out.println("Total Fees = "+totalFees);
				System.out.println("Tution Fees = "+fees.getTutionFees());
				System.out.println("Transport Fees = "+fees.getTransportFees());
				System.out.println("Examination Fees = "+fees.getExaminationFees());
				break;
			case 3: 
				System.out.println("Enter student id to find details: ");
				int id = sc.nextInt();
				Student studentDetails = services.getStudentDetails(id);
				System.out.println(studentDetails);
				break;
			case 4:
				List<Student> allStudentDetails = services.getAllStudentDetails();		
				System.out.println(allStudentDetails);
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}
			System.out.println("Do you want to continue(y/n): ");
			ch = sc.next().charAt(0);
		}
		sc.close();
	}

}
