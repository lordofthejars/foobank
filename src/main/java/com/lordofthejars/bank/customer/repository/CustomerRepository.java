package com.lordofthejars.bank.customer.repository;

import com.lordofthejars.bank.customer.Customer;

public interface CustomerRepository {

	Customer getCustomerByNameAndPassword(String name, String passsword);
	
}
