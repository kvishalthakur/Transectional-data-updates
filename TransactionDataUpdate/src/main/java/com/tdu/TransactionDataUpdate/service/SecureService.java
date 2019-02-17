package com.tdu.TransactionDataUpdate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tdu.TransactionDataUpdate.dao.SecureDao;

@Service
public class SecureService {
	
	@Autowired
	 SecureDao SecureDao;
	
	public String getStateName(String region) {
		return SecureDao.getStateName(region);
	}

}
