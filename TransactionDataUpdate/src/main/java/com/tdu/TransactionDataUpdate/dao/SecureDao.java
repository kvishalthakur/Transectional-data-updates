package com.tdu.TransactionDataUpdate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SecureDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//@Autowired
	//TDUconfigProperties tdUconfigProperties;
	
	//@Autowired
	//SqlDatasourceHelper dataSourceHelper;
	
	/*public void setJdbcTemplate() {
		jdbcTemplate
		.setDataSource(dataSourceHelper.getDatasourceByName(tdUconfigProperties.getC1vDatasourceName()));	}
	*/
	
	@SuppressWarnings("unchecked")
	public String getStateName(String region) {
		//setJdbcTemplate();
		return (String) (jdbcTemplate
				.queryForObject(
						"select distinct state_name from app.regional_structure where region = ?",
						new Object[] { region }, String.class));
	}
}
