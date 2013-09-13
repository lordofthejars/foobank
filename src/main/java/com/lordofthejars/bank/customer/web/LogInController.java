package com.lordofthejars.bank.customer.web;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.lordofthejars.bank.customer.Customer;
import com.lordofthejars.bank.customer.repository.CustomerRepository;


@Named
@RequestScoped
public class LogInController {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7228741659426593515L;
	
	private String username;
	private String password;
	
	@Named("currentCustomer")
	@Produces
	@SessionScoped
	private Customer currentCustomer = new Customer();

	@Inject
	private CustomerRepository customerRepository;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String startSession() {
		
		currentCustomer = customerRepository.getCustomerByNameAndPassword(username, password);
		
		if(currentCustomer != null) {
			return "success";			
		} else {
			return null;
		}
		
	}
	
}
