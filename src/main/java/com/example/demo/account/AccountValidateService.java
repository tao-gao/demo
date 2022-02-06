package com.example.demo.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.utils.ConfigUtility;

@Component
public class AccountValidateService {
	
	@Autowired
	private ConfigUtility configUtility;
	
	public AccountValidateResponse validateInAllSources(AccountValidateRequest req) {
		RestTemplate restTemplate = new RestTemplate();
		AccountValidateResponse response = new AccountValidateResponse();
		
		for(AccountDataSources dataSource : AccountDataSources.values()) {
			String source = dataSource.getSource();
			String uri = configUtility.getProperty(source);
			AccountStatus accountStatus = restTemplate.postForObject(uri, req, AccountStatus.class);
			accountStatus.setSource(source);
			
			response.getResult().add(accountStatus);
		}
		
		return response;
	}
	
	public AccountStatus validateInSource(String source) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = configUtility.getProperty(source);
		AccountStatus accountStatus = restTemplate.postForObject(uri, new Account(source), AccountStatus.class);
		accountStatus.setSource(source);
		
		return accountStatus;
	}
}
