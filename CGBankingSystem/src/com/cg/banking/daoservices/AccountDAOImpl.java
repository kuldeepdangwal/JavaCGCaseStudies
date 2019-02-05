package com.cg.banking.daoservices;

import java.util.ArrayList;
import java.util.List;

import com.cg.banking.beans.Account;
import com.cg.banking.util.BankingDBUtil;

public class AccountDAOImpl implements AccountDAO{

	@Override
	public Account save(Account account) {
		account.setAccountNo(BankingDBUtil.getACCOUNT_NUMBER());
		BankingDBUtil.accounts.put(account.getAccountNo(),account);
		return account;
	}

	@Override
	public boolean update(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account findOne(long accountNo) {
		return BankingDBUtil.accounts.get(accountNo);
	}

	@Override
	public List<Account> findAll() {
		ArrayList<Account> accounts = new ArrayList<Account>(BankingDBUtil.accounts.values());
		return accounts;
	}

}
