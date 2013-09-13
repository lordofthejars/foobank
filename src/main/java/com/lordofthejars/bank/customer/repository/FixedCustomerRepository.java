package com.lordofthejars.bank.customer.repository;

import java.util.ArrayList;
import java.util.List;

import com.lordofthejars.bank.account.Account;
import com.lordofthejars.bank.account.repository.FixedAccountRepository;
import com.lordofthejars.bank.customer.Customer;

public class FixedCustomerRepository implements CustomerRepository {

	public static List<Customer> customers = new ArrayList<Customer>(){
		{
			List<Account> accounts = FixedAccountRepository.accounts;
			
			add(new Customer("aa", "bb", 18, accounts.subList(0, 2)));
			add(new Customer("cc", "dd", 16, accounts.subList(2, 3)));
			
		}
	};
	
	@Override
	public Customer getCustomerByNameAndPassword(String name, String password) {
		for (Customer customer : customers) {
			if(customer.getName().equals(name) && customer.getPassword().equals(password)) {
				return customer;
			}
		}
		
		return null;
	}

}
