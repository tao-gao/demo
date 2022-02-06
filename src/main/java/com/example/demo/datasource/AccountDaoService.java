package com.example.demo.datasource;

import org.springframework.stereotype.Component;

@Component
public class AccountDaoService {
	public AccountStatus acountValidateSource1(Account account) {
		return new AccountStatus(false);
	}
	
	public AccountStatus acountValidateSource2(Account account) {
		return new AccountStatus(true);
	}
}
