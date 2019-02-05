package com.cg.banking.util;

import java.util.HashMap;

import com.cg.banking.beans.Account;
public class BankingDBUtil {
	public static HashMap<Long, Account> accounts = new HashMap<Long, Account>();

	private static long ACCOUNT_NUMBER=100;
	private static int TRANSACTION_NO_COUNTER = 01;

	public static long getACCOUNT_NUMBER() {
		return ++ACCOUNT_NUMBER;
	}
	
	public static int getTRANSACTION_NO_COUNTER() {
		return TRANSACTION_NO_COUNTER++;
	}
}
