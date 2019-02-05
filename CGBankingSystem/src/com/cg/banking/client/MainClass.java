package com.cg.banking.client;

import java.util.List;
import java.util.Scanner;
import com.cg.banking.beans.Account;
import com.cg.banking.services.BankingServices;
import com.cg.banking.services.BankingServicesImpl;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankingServices bankingServices = new BankingServicesImpl();
		System.out.println("******************BANKING SYSTEM********************");
		char ch='y';
		while(ch=='y'||ch=='Y') {
			System.out.println("Enter your choice:\n1. Open Account\n2. Get Account Details"
					+ "\n3. Get All Account Details"+"\n4. Deposit"+"\n5. Withdraw");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter your Account type:\n1. Savings \n2. Current");
				int in = sc.nextInt();
				System.out.println("Enter initial balance:");
				int initBalance = sc.nextInt();
				System.out.println("Account created : KINDLY NOTE YOUR CREDENTIALS");
				if(in==1)
					System.out.println(bankingServices.openAccount("Savings" , initBalance));
				else
					System.out.println(bankingServices.openAccount("Current" , initBalance));
				 break;
			case 2: 
				System.out.println("Enter Account number to find details: ");
				int accountNo = sc.nextInt();
				Account accountDetails = bankingServices.getAccountDetails(accountNo);
				System.out.println(accountDetails);
				break;
			case 3:
				List<Account> allAccountDetails = bankingServices.getAllAccountsDetails();		
				System.out.println(allAccountDetails);
				break;
			case 4:
				System.out.println("****DEPOSIT MONEY IN ACCOUNT****");
				System.out.println("Enter your account number");
				long accNo = sc.nextLong();
				System.out.println("Enter the amount you want to deposit");
				float depAmount = sc.nextFloat();
				float newAmount = bankingServices.depositAmount(accNo, depAmount);
				System.out.println("Transaction successful \nUpdated Balance  :" + newAmount);
				break;
			case 5:
				 System.out.println("****WITHDRAW MONEY FROM ACCOUNT****");
				 System.out.println("Enter your account number");
				 accNo = sc.nextLong();
				 System.out.println("Enter the amount you want to Withdraw");
				 float withAmount = sc.nextFloat();
				 System.out.println("Enter your pin number");
				 int pinNo = sc.nextInt();
				 newAmount = bankingServices.withdrawAmount(accNo, withAmount, pinNo);
				 System.out.println("Transaction successful \nUpdated Balance" + newAmount);
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
