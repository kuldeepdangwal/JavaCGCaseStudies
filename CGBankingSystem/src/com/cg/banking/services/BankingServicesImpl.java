package com.cg.banking.services;

import java.util.HashMap;
import java.util.List;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.AccountDAO;
import com.cg.banking.daoservices.AccountDAOImpl;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.util.BankingDBUtil;

public class BankingServicesImpl implements BankingServices{

	private AccountDAO accountDao = new AccountDAOImpl();

	@Override
	public Account openAccount(String accountType, float initBalance)
			throws InvalidAmountException, InvalidAccountTypeException, BankingServicesDownException {

		int pinNumber =(int)(Math.random()*10000);
		if(pinNumber<1000)
			pinNumber=pinNumber*10;
		else if (pinNumber<100)
			pinNumber=pinNumber*100;
		else if(pinNumber<10)
			pinNumber=pinNumber*1000;

		String accountStatus="ACTIVE";
		HashMap<Integer, Transaction> transactions = new HashMap<Integer, Transaction>();

		Account account = new Account(pinNumber, accountType, accountStatus, initBalance, transactions);

		if(initBalance<5000)
			throw new InvalidAmountException("Invalid initial amount");
		else if(accountType.isEmpty())
			throw new InvalidAccountTypeException("Account type is not valid");
		else
			account = accountDao.save(account);
		return account;
	}

	@Override
	public float depositAmount(long accountNo, float amount)
			throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
		Account account = getAccountDetails(accountNo);

		if(account.getAccountStatus().equalsIgnoreCase("ACTIVE")) {
			float newAmount = account.getAccountBalance() + amount;
			account.setAccountBalance(newAmount);
			int transactionId = BankingDBUtil.getTRANSACTION_NO_COUNTER();
			Transaction transaction = new Transaction(transactionId, amount , "DEPOSITED");
			account.getTransactions().put(1, transaction);
			return newAmount;
		}
		else 
			throw new AccountBlockedException("This account has been blocked");
	}

	@Override
	public float withdrawAmount(long accountNo, float amount, int pinNumber) throws InsufficientAmountException,
	AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		int count=0;
		Account accnt = getAccountDetails(accountNo);
		if(accnt.getAccountStatus().equalsIgnoreCase("ACTIVE")) {
			if(accnt.getPinNumber()==pinNumber){
				float newAmount = accnt.getAccountBalance() - amount ; 
				if(newAmount < 500) 
					throw new InsufficientAmountException("Balance cannot go below 500");
				else
					accnt.setAccountBalance(newAmount);
				return newAmount;
			}
			else 
				throw new InvalidPinNumberException("YOUR PIN IS WRONG");	
		}
		else 
			throw new AccountBlockedException("YOUR ACCOUNT HAS BEEN BLOCKED");
	}

	@Override
	public boolean fundTransfer(long accountNoTo, long accountNoFrom, float transferAmount, int pinNumber)
			throws InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException,
			BankingServicesDownException, AccountBlockedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account getAccountDetails(long accountNo) throws AccountNotFoundException, BankingServicesDownException {
		Account account = accountDao.findOne(accountNo);
		if(account==null)
			throw new AccountNotFoundException("Account not found for account number = "+accountNo);

		return account;
	}

	@Override
	public List<Account> getAllAccountsDetails() throws BankingServicesDownException {	
		return accountDao.findAll();
	}

	@Override
	public List<Transaction> getAccountAllTransaction(long accountNo)
			throws BankingServicesDownException, AccountBlockedException {
		// TODO Auto-generated method stub
		return null;
	}
}
