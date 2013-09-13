package com.lordofthejars.bank.account;

public class Account {
	
	private String accountNumber;
	private int balance;
	
	public Account() {
		
	}
	
	public Account(String accountNumber, int balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public void withdraw(int amount) {
		this.balance = this.balance - amount;
	}
	
	public void deposit(int amount) {
		this.balance = this.balance + amount;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public String toString() {
		return this.getAccountNumber();
	}
	
}
