package com.lordofthejars.bank.customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lordofthejars.bank.account.Account;

public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2692936915554094415L;
	
	private String name;
	private String password;
	private int age;
	
	private List<Account> accounts = new ArrayList<Account>();

	public Customer() {
		
	}
	
	public Customer(String name, String password, int age, List<Account> accounts) {
		super();
		this.name = name;
		this.age = age;
		this.accounts = accounts;
		this.password = password;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getPassword() {
		return password;
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}
	
	public void addAccount(Account account) {
		this.accounts.add(account);
	}
	
}
