package com.lordofthejars.bank.account.web;

import java.io.File;

import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import com.lordofthejars.bank.Resources;
import com.lordofthejars.bank.account.Account;
import com.lordofthejars.bank.account.AccountService;
import com.lordofthejars.bank.account.SecureAccountService;
import com.lordofthejars.bank.account.repository.AccountRepository;
import com.lordofthejars.bank.account.repository.FixedAccountRepository;
import com.lordofthejars.bank.customer.Customer;
import com.lordofthejars.bank.customer.repository.CustomerRepository;
import com.lordofthejars.bank.customer.repository.FixedCustomerRepository;
import com.lordofthejars.bank.customer.web.LogInController;

public class Deployments {

	private static final String WEBAPP_SRC = "src/main/webapp";
	
	public static WebArchive createLogin() {
		return ShrinkWrap
				.create(WebArchive.class, "login.war")
				.addClass(Resources.class)
				.addClasses(Account.class, AccountService.class,
						SecureAccountService.class, TransferController.class,
						AccountRepository.class, FixedAccountRepository.class)
				.addClasses(Customer.class, LogInController.class,
						CustomerRepository.class, FixedCustomerRepository.class)
				.merge(ShrinkWrap.create(GenericArchive.class)
						.as(ExplodedImporter.class)
						.importDirectory(WEBAPP_SRC + "/resources/css")
						.as(GenericArchive.class), "/resources/css", Filters.includeAll())
				.merge(ShrinkWrap.create(GenericArchive.class)
						.as(ExplodedImporter.class)
						.importDirectory(WEBAPP_SRC + "/resources/fonts")
						.as(GenericArchive.class), "/resources/fonts", Filters.includeAll())
				.merge(ShrinkWrap.create(GenericArchive.class)
						.as(ExplodedImporter.class)
						.importDirectory(WEBAPP_SRC + "/resources/js")
						.as(GenericArchive.class), "/resources/js", Filters.includeAll())
				.addAsWebResource(new File(WEBAPP_SRC, "login.xhtml"))
				.addAsWebResource(new File(WEBAPP_SRC, "template.xhtml"))
				.addAsWebResource(new File(WEBAPP_SRC, "transfer.xhtml"))
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsWebInfResource(
						new File(WEBAPP_SRC, "WEB-INF/faces-config.xml"))
				.addAsWebInfResource(new File(WEBAPP_SRC, "WEB-INF/web.xml"));
	}
	
}
