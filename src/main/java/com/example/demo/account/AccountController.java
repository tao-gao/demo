package com.example.demo.account;

import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.datasource.Account;
import com.example.demo.utils.ConfigUtility;

@RestController
public class AccountController {

	@Autowired
	private AccountValidateService accountValidateService;

	@PostMapping(path = "/account/validate")
	public Callable<AccountValidateResponse> accountValidate(@RequestBody AccountValidateRequest accountReq) {
		return () -> {
			// Thread.sleep(3000);
			AccountValidateResponse response = new AccountValidateResponse();

			List<String> sources = accountReq.getSources();
			if (sources == null || sources.size() == 0) {
				response = accountValidateService.validateInAllSources(accountReq);
			} else {
				for (String source : sources) {
					AccountDataSources dataSource = AccountDataSources.resolveSource(source);
					if (dataSource != null) {
						AccountStatus accountStatus = accountValidateService.validateInSource(source);
						response.getResult().add(accountStatus);
					}
				}
			}

			return response;
		};
	}

	// Override timeouts in request factory
	private SimpleClientHttpRequestFactory getClientHttpRequestFactory() {
		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		// Connect timeout
		clientHttpRequestFactory.setConnectTimeout(120_000);

		// Read timeout
		clientHttpRequestFactory.setReadTimeout(120_000);
		return clientHttpRequestFactory;
	}
}
