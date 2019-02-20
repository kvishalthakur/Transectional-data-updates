package com.tdu.TransactionDataUpdate.dao;

import java.sql.Types;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.tdu.TransactionDataUpdate.config.TDUSqlConfiguration;

@Repository
public class WorkOrderStatusDao {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	TDUSqlConfiguration tduSqlConfiguration;
	
	@Autowired
	NamedParameterJdbcTemplate namedTemplate;
	
	SimpleJdbcCall simpleJdbcCall;
	
	
	//@Autowired
	//TDUconfigProperties tdUconfigProperties;
	
	//@Autowired
	//SqlDatasourceHelper dataSourceHelper;
	
	/*public void setJdbcTemplate() {
		jdbcTemplate
		.setDataSource(dataSourceHelper.getDatasourceByName(tdUconfigProperties.getC1vDatasourceName()));	}
	*/
		
	public int saveW1vTxnData(Map<String, String> trnData, String xmlData){  
		
		int update = 0;
		
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		
		paramSource.addValue("registers2dials", trnData.get("r2dials")); 
		paramSource.addValue("registers2encoderid", trnData.get("r2encoderId")); 
		paramSource.addValue("registers2miunumber", trnData.get("r2mIUNumber")); 
		paramSource.addValue("registers2newread", trnData.get("r2newRead")); 
		paramSource.addValue("registers2oldread", trnData.get("r2oldRead")); 
		paramSource.addValue("registers2readtype", trnData.get("r2readType")); 
		paramSource.addValue("registers2size", trnData.get("r2size")); 
		
		paramSource.addValue("activityreason", trnData.get("activityReason"));           
		paramSource.addValue("additionalinformation", trnData.get("additionalInformation"));
		paramSource.addValue("additionalworkneeded", trnData.get("additionalWorkNeeded"));
		paramSource.addValue("assignedengineer", trnData.get("assignedEngineer"));
		paramSource.addValue("assignedstart", trnData.get("assignmentStart"), Types.TIMESTAMP);
		paramSource.addValue("assignedend", trnData.get("assignmentEnd"), Types.TIMESTAMP);
		paramSource.addValue("backofficereview", trnData.get("backOfficeReview"));
		paramSource.addValue("completionstatus", trnData.get("completionStatus"));
		paramSource.addValue("curbboxmeasurementdescription", trnData.get("curbBoxMeasurementDescription"));
		paramSource.addValue("descriptions", trnData.get("descriptions"));
		paramSource.addValue("devicecategory", trnData.get("deviceCategory"));
		paramSource.addValue("registers1dials", trnData.get("r1dials")); 
		paramSource.addValue("dispatchid", trnData.get("dispatchId"));
		paramSource.addValue("registers1encoderid", trnData.get("r1encoderId")); 
		paramSource.addValue("engineerid", trnData.get("engineerId"));
		paramSource.addValue("fsrid", trnData.get("fsrId"), Types.INTEGER);
		paramSource.addValue("heattype", trnData.get("heatType"));
		paramSource.addValue("installation", trnData.get("installation"));
		paramSource.addValue("manufacturerserialnumber", trnData.get("manufacturerSerialNumber"));
		paramSource.addValue("meterdirectionallocation", trnData.get("meterDirectionalLocation"));
		paramSource.addValue("meterpositionlocation", trnData.get("meterPositionLocation"));
		paramSource.addValue("meterserialnumber", trnData.get("meterSerialNumber"));
		paramSource.addValue("metersupplementallocation", trnData.get("meterSupplementalLocation"));
		paramSource.addValue("miscinvoice", trnData.get("miscInvoice"));
		paramSource.addValue("registers1miunumber", trnData.get("r1mIUNumber")); 
		paramSource.addValue("registers1newread", trnData.get("r1newRead")); 
		paramSource.addValue("notes", trnData.get("notes"));
		paramSource.addValue("oldmeterserialnumber", trnData.get("oldMeterSerialNumber"));
		paramSource.addValue("registers1oldread", trnData.get("r1oldRead")); 
		paramSource.addValue("operatedpointofcontrol", trnData.get("operatedPointOfControl"));
		paramSource.addValue("operationnumber", trnData.get("operationNumber"));
		paramSource.addValue("purpose", trnData.get("purpose"));
		paramSource.addValue("qualityissue", trnData.get("qualityIssue"));
		paramSource.addValue("rating", trnData.get("rating"));
		paramSource.addValue("readingdevicedirectionallocation", trnData.get("readingDeviceDirectionalLocation"));
		paramSource.addValue("readingdevicepositionallocation", trnData.get("readingDevicePositionalLocation"));
		paramSource.addValue("readingdevicesupplementallocation", trnData.get("readingDeviceSupplementalLocation"));
		paramSource.addValue("registers1readtype", trnData.get("r1readType")); 
		paramSource.addValue("safety", trnData.get("safety"));
		paramSource.addValue("serialnumber", trnData.get("serialNumber"));
		paramSource.addValue("servicefound", trnData.get("serviceFound"));
		paramSource.addValue("serviceleft", trnData.get("serviceLeft"));
		paramSource.addValue("registers1size", trnData.get("r1size")); 
		paramSource.addValue("statusnonnumber", trnData.get("statusNonNumber"));
		paramSource.addValue("statusnotes", trnData.get("statusNotes"));
		paramSource.addValue("statusnumber", trnData.get("statusNumber"));
		paramSource.addValue("itemtimestamp", trnData.get("itemTimeStamp"),Types.TIMESTAMP);
		paramSource.addValue("technicalinspectedby", trnData.get("technicalInspectedBy"));
		paramSource.addValue("technicalinspectedon", trnData.get("technicalInspectedOn"),Types.DATE);
		paramSource.addValue("workordernumber", trnData.get("workOrderNumber"));
		paramSource.addValue("sourcesystemname", "w1v");
		paramSource.addValue("transactiontype", trnData.get("transactiontype"));
		paramSource.addValue("inputjson", xmlData, Types.SQLXML);
		paramSource.addValue("processed", "N");
		paramSource.addValue("actionflag", trnData.get("actionFlag")); 
		
		try {
			update = namedTemplate.update(tduSqlConfiguration.getSaveTransactionData(), paramSource);
		}catch(Exception e) {
			log.error("Getting exception in update record function "+ e);
			System.out.println("Getting exception in update record function "+ e);
		}
		
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("txn_data").withFunctionName("w1v_trans_data_update");
		SqlParameterSource in = new MapSqlParameterSource();
		Boolean executeFunction = simpleJdbcCall.executeFunction(Boolean.class, in);
		log.info("w1v_trans_data_update sql function returns = "+ executeFunction);
		return update;
	}
	
}
