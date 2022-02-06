package com.example.demo.account;

import java.util.List;

public class AccountValidateRequest {
	private String accountNumber;
	private List<String> sources;

	public AccountValidateRequest() {
		super();
	}

	public AccountValidateRequest(String accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public List<String> getSources() {
		return sources;
	}

	public void setSources(List<String> sources) {
		this.sources = sources;
	}
}
