package com.example.demo.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountResources {
	
	@Autowired
	private AccountDaoService service;
	
	@PostMapping(path="/v1/api/account/validate")
	public AccountStatus acountValidateSource1(@RequestBody Account account) {
		return service.acountValidateSource1(account);
	}
	
	@PostMapping(path="/v2/api/account/validate")
	public AccountStatus acountValidateSource2(@RequestBody Account account) {
		return service.acountValidateSource2(account);
	}
}
