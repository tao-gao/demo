package com.example.demo.account;

import java.util.ArrayList;
import java.util.List;

public class AccountValidateResponse {
	private List<AccountStatus> result;

	public AccountValidateResponse() {
		super();
	}

	public List<AccountStatus> getResult() {
		if(result == null) {
			result = new ArrayList<AccountStatus>();
		}
		return result;
	}

	public void setResult(List<AccountStatus> result) {
		this.result = result;
	}
	
}
