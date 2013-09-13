package com.lordofthejars.bank.account.repository;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.lordofthejars.bank.account.Account;

@ApplicationScoped
public class FixedAccountRepository implements AccountRepository {

	public static List<Account> accounts = new ArrayList<Account>() {
			{
				add(new Account("AA00", 100));
				add(new Account("BB00", 200));
				add(new Account("CC00", 300));
			}
		};
	
	
	@Override
	public void createAccount(Account account) {
		accounts.add(account);
	}
		
	@Override
	public Account getForAccountNumber(String accountNumber) {
		for (Account account : this.accounts) {
			if(account.getAccountNumber().equals(accountNumber)) {
				return account;
			}
		}
		return null;
	}

}
