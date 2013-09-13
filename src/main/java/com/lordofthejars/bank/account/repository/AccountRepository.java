package com.lordofthejars.bank.account.repository;

import com.lordofthejars.bank.account.Account;

public interface AccountRepository {

	Account getForAccountNumber(String accountNumber);

	void createAccount(Account account);
	
}
