package com.example.demo.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountStatus {
	private String source;
	private boolean isValid;

	public AccountStatus() {
		super();
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public boolean isIsValid() {
		return isValid;
	}

	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}
}
