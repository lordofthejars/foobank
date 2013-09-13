package com.lordofthejars.bank.account.web;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.lordofthejars.bank.account.Account;
import com.lordofthejars.bank.account.AccountService;
import com.lordofthejars.bank.account.SecureAccountService;
import com.lordofthejars.bank.account.repository.AccountRepository;
import com.lordofthejars.bank.account.repository.FixedAccountRepository;

@RunWith(Arquillian.class)
public class WhenACustomerTransferMoney {

	@Deployment
	public static JavaArchive createDeployment() {
		JavaArchive javaArchive = ShrinkWrap.create(JavaArchive.class)
				.addClass(SecureAccountService.class)
				.addClass(Account.class)
				.addClass(AccountService.class)
				.addClass(AccountRepository.class)
				.addClass(FixedAccountRepository.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		return javaArchive;
	}

	@Inject
	AccountService accountService;
	
	@Inject
	AccountRepository accountRepository;
	
	@Test
	public void money_should_be_transferred_from_his_account_to_other_account() {
		
		accountRepository.createAccount(new Account("my_account", 1000));
		accountRepository.createAccount(new Account("other_account", 500));

		accountService.transfer("my_account", "other_account", 250);
		
		Account fromAccount = accountRepository.getForAccountNumber("my_account");
		Account toAccount = accountRepository.getForAccountNumber("other_account");
		
		assertThat(fromAccount.getBalance(), is(750));
		assertThat(toAccount.getBalance(), is(750));
		
	}
	
}
