package com.tdu.TransactionDataUpdate.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="tdu.sql")
public class TDUSqlConfiguration {
	
	private String saveTransactionData;

	public String getSaveTransactionData() {
		return saveTransactionData;
	}

	public void setSaveTransactionData(String saveTransactionData) {
		this.saveTransactionData = saveTransactionData;
	}
	
	
	


	
		
}
