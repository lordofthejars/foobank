package com.lordofthejars.bank.account.web;

import java.io.File;
import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.lordofthejars.bank.account.Account;
import com.lordofthejars.bank.account.AccountService;
import com.lordofthejars.bank.account.SecureAccountService;
import com.lordofthejars.bank.account.repository.AccountRepository;
import com.lordofthejars.bank.account.repository.FixedAccountRepository;
import com.lordofthejars.bank.customer.Customer;
import com.lordofthejars.bank.customer.repository.CustomerRepository;
import com.lordofthejars.bank.customer.repository.FixedCustomerRepository;
import com.lordofthejars.bank.customer.web.LogInController;

@RunWith(Arquillian.class)
@RunAsClient
public class WhenACustomerEnterItsCredentials {

	private static final String WEBAPP_SRC = "src/main/webapp";
    
    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "login.war")
            .addClasses(Account.class, AccountService.class, SecureAccountService.class, TransferController.class, AccountRepository.class, FixedAccountRepository.class)
            .addClasses(Customer.class, LogInController.class, CustomerRepository.class, FixedCustomerRepository.class)
            .addAsWebResource(new File(WEBAPP_SRC, "login.xhtml"))
            .addAsWebResource(new File(WEBAPP_SRC, "template.xhtml"))
            .addAsWebResource(new File(WEBAPP_SRC, "transfer.xhtml"))
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsWebInfResource(new File(WEBAPP_SRC, "WEB-INF/faces-config.xml"))
            .addAsWebInfResource(new File(WEBAPP_SRC, "WEB-INF/web.xml"));
    }
    
    @ArquillianResource
    URL contextPath;
    
    @Drone
    WebDriver driver;
    
    @Test
    public void test() {
    	System.out.println(contextPath);
    	driver.get(contextPath+"login.xhtml");
    	
    	
    }
	
}
