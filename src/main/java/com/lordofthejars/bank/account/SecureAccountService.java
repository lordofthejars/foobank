package com.lordofthejars.bank.account;

import javax.inject.Inject;

import com.lordofthejars.bank.account.repository.AccountRepository;

public class SecureAccountService implements AccountService {

	@Inject
	private AccountRepository accountRepository;
	
	@Override
	public void transfer(String from, String to, int amount) {
		
		Account toAccount = this.accountRepository.getForAccountNumber(to);
		Account fromAccount = this.accountRepository.getForAccountNumber(from);
		
		fromAccount.withdraw(amount);
		toAccount.deposit(amount);
	}

}
