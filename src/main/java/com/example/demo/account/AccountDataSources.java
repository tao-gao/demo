package com.example.demo.account;

public enum AccountDataSources {

	SOURCE1("source1"), SOURCE2("source2");

	private String source;

	private AccountDataSources(String source) {
		this.source = source;
	}

	public String getSource() {
		return source;
	}

	public static AccountDataSources resolveSource(String source) {
		for (AccountDataSources e : AccountDataSources.values()) {
			if (e.getSource().equals(source)) {
				return e;
			}
		}

		return null;
	}
}
