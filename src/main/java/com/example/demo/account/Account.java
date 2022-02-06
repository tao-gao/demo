package com.example.demo.account;

public class Account {
	private String accountNumber;

	public Account() {
		super();
	}

	public Account(String accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
