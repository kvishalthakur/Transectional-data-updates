package com.tdu.TransactionDataUpdate.dao;

import java.sql.Types;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tdu.TransactionDataUpdate.config.TDUSqlConfiguration;

//import com.apporchid.jpa.cpool.SqlDatasourceHelper;
//import com.tdu.TransactionDataUpdate.config.TDUconfigProperties;

@Repository
public class WorkOrderStatusDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	TDUSqlConfiguration tduSqlConfiguration;
	
	@Autowired
	NamedParameterJdbcTemplate namedTemplate;
	
	//@Autowired
	//TDUconfigProperties tdUconfigProperties;
	
	//@Autowired
	//SqlDatasourceHelper dataSourceHelper;
	
	/*public void setJdbcTemplate() {
		jdbcTemplate
		.setDataSource(dataSourceHelper.getDatasourceByName(tdUconfigProperties.getC1vDatasourceName()));	}
	*/
	public void saveIncomplateWorkOrder(Map trnData, String xmlData){  
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		
		paramSource.addValue("accuracy", trnData.get("accuracy"));
		paramSource.addValue("activityreason", "201");           
		paramSource.addValue("additionalinformation", trnData.get("additionalInformation"));
		paramSource.addValue("additionalworkneeded", trnData.get("additionalWorkNeeded"));
		paramSource.addValue("assignedengineer", trnData.get("assignedEngineer"));
		paramSource.addValue("assignedstart", trnData.get("assignmentStart"), Types.DATE);
		paramSource.addValue("assignedend", trnData.get("assignmentEnd"), Types.DATE);
		paramSource.addValue("backofficereview", trnData.get("backOfficeReview"));
		paramSource.addValue("calculatedvolume", trnData.get("calculatedVolume"));
		paramSource.addValue("completionstatus", trnData.get("completionStatus"));
		paramSource.addValue("curbboxmeasurementdescription", trnData.get("curbBoxMeasurementDescription"));
		paramSource.addValue("description", trnData.get("description"));
		paramSource.addValue("devicecategory", trnData.get("deviceCategory"));
		paramSource.addValue("dials", trnData.get("dials"));
		paramSource.addValue("dispatchid", null);
		paramSource.addValue("encoderid", null);
		paramSource.addValue("endread", trnData.get("endRead"));
		paramSource.addValue("engineerid", null);
		paramSource.addValue("fsrid", null);
		paramSource.addValue("heattype", trnData.get("heatType"));
		paramSource.addValue("initialrepair", trnData.get("initialRepair"));
		paramSource.addValue("installation", trnData.get("installation"));
		paramSource.addValue("lowmedhighindicator", trnData.get("lowMedHighIndicator"));
		paramSource.addValue("manufacturerserialnumber", trnData.get("manufacturerSerialNumber"));
		paramSource.addValue("meterdirectionallocation", trnData.get("meterDirectionAllocation"));
		paramSource.addValue("meterpositionlocation", trnData.get("meterPositionLocation"));
		paramSource.addValue("meterserialnumber", trnData.get("meterSerialNumber"));
		paramSource.addValue("metersupplementallocation", trnData.get("meterSupplementAllocation"));
		paramSource.addValue("miscinvoice", trnData.get("miscInvoice"));
		paramSource.addValue("miunumber", trnData.get("mIUNumber"));
		paramSource.addValue("newread", trnData.get("newRead"));
		paramSource.addValue("notes", trnData.get("notes"));
		paramSource.addValue("oldmeterserialnumber", trnData.get("oldMeterSerialNumber"));
		paramSource.addValue("oldread", trnData.get("oldRead"));
		paramSource.addValue("operatedpointofcontrol", trnData.get("operatedPointOfControl"));
		paramSource.addValue("operationnumber", trnData.get("operationNumber"));
		paramSource.addValue("purpose", trnData.get("purpose"));
		paramSource.addValue("qualityissue", trnData.get("qualityIssue"));
		paramSource.addValue("rating", trnData.get("rating"));
		paramSource.addValue("readingdevicedirectionallocation", trnData.get("readingDeviceDirectionalLocation"));
		paramSource.addValue("readingdevicepositionallocation", trnData.get("readingDevicePositionalLocation"));
		paramSource.addValue("readingdevicesupplementallocation", trnData.get("readingDeviceSupplementalLocation"));
		paramSource.addValue("readtype", trnData.get("readType"));
		paramSource.addValue("registerid", null);
		paramSource.addValue("safety", trnData.get("safety"));
		paramSource.addValue("serialnumber", trnData.get("serialNumber"));
		paramSource.addValue("servicefound", trnData.get("serviceFound"));
		paramSource.addValue("serviceleft", trnData.get("serviceLeft"));
		paramSource.addValue("size", trnData.get("size"));
		paramSource.addValue("startread", trnData.get("startRead"));
		paramSource.addValue("statusnonnumber", trnData.get("statusNonNumber"));
		paramSource.addValue("statusnotes", trnData.get("statusNotes"));
		paramSource.addValue("statusnumber", trnData.get("statusNumber"));
		paramSource.addValue("itemtimestamp", trnData.get("itemTimeStamp"),Types.TIMESTAMP);
		paramSource.addValue("technicalinspectedby", trnData.get("technicalInspectedBy"));
		paramSource.addValue("technicalinspectedon", trnData.get("technicalInspectedOn"),Types.TIMESTAMP);
		paramSource.addValue("workordernumber", trnData.get("workOrderNumber"));
		paramSource.addValue("sourcesystemname", "w1v");
		paramSource.addValue("transactiontype", "complate");
		paramSource.addValue("inputjson", xmlData, Types.SQLXML);
		paramSource.addValue("processed", "Y");
		paramSource.addValue("addts", null);
		paramSource.addValue("processedts", null);
		
		
		int update = namedTemplate.update("INSERT INTO txn_data.w1v_transaction_data(accuracy, activityreason, additionalinformation, additionalworkneeded, assignedengineer,assignedstart,assignedend, backofficereview, calculatedvolume, completionstatus,curbboxmeasurementdescription, description,devicecategory,dials,dispatchid, encoderid, endread, engineerid, fsrid, heattype, initialrepair, installation, lowmedhighindicator, manufacturerserialnumber, meterdirectionallocation, meterpositionlocation,meterserialnumber, metersupplementallocation, miscinvoice, miunumber, newread, notes, oldmeterserialnumber, oldread, operatedpointofcontrol, operationnumber, purpose, qualityissue, rating, readingdevicedirectionallocation, readingdevicepositionallocation, readingdevicesupplementallocation, readtype, registerid, safety, serialnumber, servicefound, serviceleft, size, startread, statusnonnumber, statusnotes,statusnumber, itemtimestamp, technicalinspectedby, technicalinspectedon, workordernumber, sourcesystemname, transactiontype, inputjson, processed, addts, processedts) VALUES(:accuracy, :activityreason, :additionalinformation, :additionalworkneeded, :assignedengineer, :assignedstart, :assignedend, :backofficereview, :calculatedvolume, :completionstatus, :curbboxmeasurementdescription, :description, :devicecategory, :dials, :dispatchid, :encoderid, :endread, :engineerid, :fsrid, :heattype, :initialrepair, :installation, :lowmedhighindicator, :manufacturerserialnumber, :meterdirectionallocation, :meterpositionlocation, :meterserialnumber, :metersupplementallocation, :miscinvoice, :miunumber, :newread, :notes, :oldmeterserialnumber, :oldread, :operatedpointofcontrol, :operationnumber, :purpose, :qualityissue, :rating, :readingdevicedirectionallocation, :readingdevicepositionallocation, :readingdevicesupplementallocation, :readtype, :registerid, :safety, :serialnumber, :servicefound, :serviceleft, :size, :startread, :statusnonnumber, :statusnotes,:statusnumber, :itemtimestamp, :technicalinspectedby, :technicalinspectedon, :workordernumber, :sourcesystemname, :transactiontype, :inputjson, :processed, :addts, :processedts)", paramSource);
		System.out.println(update);
	
	}
	
	public void saveComplateWorkOrder(Map trnData, String xmlData){  
		
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		
		paramSource.addValue("accuracy", trnData.get("accuracy"));
		paramSource.addValue("activityreason", "201");           
		paramSource.addValue("additionalinformation", trnData.get("additionalInformation"));
		paramSource.addValue("additionalworkneeded", trnData.get("additionalWorkNeeded"));
		paramSource.addValue("assignedengineer", trnData.get("assignedEngineer"));
		paramSource.addValue("assignedstart", trnData.get("assignmentStart"), Types.DATE);
		paramSource.addValue("assignedend", trnData.get("assignmentEnd"), Types.DATE);
		paramSource.addValue("backofficereview", trnData.get("backOfficeReview"));
		paramSource.addValue("calculatedvolume", trnData.get("calculatedVolume"));
		paramSource.addValue("completionstatus", trnData.get("completionStatus"));
		paramSource.addValue("curbboxmeasurementdescription", trnData.get("curbBoxMeasurementDescription"));
		paramSource.addValue("description", trnData.get("description"));
		paramSource.addValue("devicecategory", trnData.get("deviceCategory"));
		paramSource.addValue("dials", trnData.get("dials"));
		paramSource.addValue("dispatchid", null);
		paramSource.addValue("encoderid", null);
		paramSource.addValue("endread", trnData.get("endRead"));
		paramSource.addValue("engineerid", null);
		paramSource.addValue("fsrid", null);
		paramSource.addValue("heattype", trnData.get("heatType"));
		paramSource.addValue("initialrepair", trnData.get("initialRepair"));
		paramSource.addValue("installation", trnData.get("installation"));
		paramSource.addValue("lowmedhighindicator", trnData.get("lowMedHighIndicator"));
		paramSource.addValue("manufacturerserialnumber", trnData.get("manufacturerSerialNumber"));
		paramSource.addValue("meterdirectionallocation", trnData.get("meterDirectionAllocation"));
		paramSource.addValue("meterpositionlocation", trnData.get("meterPositionLocation"));
		paramSource.addValue("meterserialnumber", trnData.get("meterSerialNumber"));
		paramSource.addValue("metersupplementallocation", trnData.get("meterSupplementAllocation"));
		paramSource.addValue("miscinvoice", trnData.get("miscInvoice"));
		paramSource.addValue("miunumber", trnData.get("mIUNumber"));
		paramSource.addValue("newread", trnData.get("newRead"));
		paramSource.addValue("notes", trnData.get("notes"));
		paramSource.addValue("oldmeterserialnumber", trnData.get("oldMeterSerialNumber"));
		paramSource.addValue("oldread", trnData.get("oldRead"));
		paramSource.addValue("operatedpointofcontrol", trnData.get("operatedPointOfControl"));
		paramSource.addValue("operationnumber", trnData.get("operationNumber"));
		paramSource.addValue("purpose", trnData.get("purpose"));
		paramSource.addValue("qualityissue", trnData.get("qualityIssue"));
		paramSource.addValue("rating", trnData.get("rating"));
		paramSource.addValue("readingdevicedirectionallocation", trnData.get("readingDeviceDirectionalLocation"));
		paramSource.addValue("readingdevicepositionallocation", trnData.get("readingDevicePositionalLocation"));
		paramSource.addValue("readingdevicesupplementallocation", trnData.get("readingDeviceSupplementalLocation"));
		paramSource.addValue("readtype", trnData.get("readType"));
		paramSource.addValue("registerid", null);
		paramSource.addValue("safety", trnData.get("safety"));
		paramSource.addValue("serialnumber", trnData.get("serialNumber"));
		paramSource.addValue("servicefound", trnData.get("serviceFound"));
		paramSource.addValue("serviceleft", trnData.get("serviceLeft"));
		paramSource.addValue("size", trnData.get("size"));
		paramSource.addValue("startread", trnData.get("startRead"));
		paramSource.addValue("statusnonnumber", trnData.get("statusNonNumber"));
		paramSource.addValue("statusnotes", trnData.get("statusNotes"));
		paramSource.addValue("statusnumber", trnData.get("statusNumber"));
		paramSource.addValue("itemtimestamp", trnData.get("itemTimeStamp"),Types.TIMESTAMP);
		paramSource.addValue("technicalinspectedby", trnData.get("technicalInspectedBy"));
		paramSource.addValue("technicalinspectedon", trnData.get("technicalInspectedOn"),Types.TIMESTAMP);
		paramSource.addValue("workordernumber", trnData.get("workOrderNumber"));
		paramSource.addValue("sourcesystemname", "w1v");
		paramSource.addValue("transactiontype", "complate");
		paramSource.addValue("inputjson", xmlData, Types.SQLXML);
		paramSource.addValue("processed", "Y");
		paramSource.addValue("addts", null);
		paramSource.addValue("processedts", null);
		
		
		int update = namedTemplate.update("INSERT INTO txn_data.w1v_transaction_data(accuracy, activityreason, additionalinformation, additionalworkneeded, assignedengineer,assignedstart,assignedend, backofficereview, calculatedvolume, completionstatus,curbboxmeasurementdescription, description,devicecategory,dials,dispatchid, encoderid, endread, engineerid, fsrid, heattype, initialrepair, installation, lowmedhighindicator, manufacturerserialnumber, meterdirectionallocation, meterpositionlocation,meterserialnumber, metersupplementallocation, miscinvoice, miunumber, newread, notes, oldmeterserialnumber, oldread, operatedpointofcontrol, operationnumber, purpose, qualityissue, rating, readingdevicedirectionallocation, readingdevicepositionallocation, readingdevicesupplementallocation, readtype, registerid, safety, serialnumber, servicefound, serviceleft, size, startread, statusnonnumber, statusnotes,statusnumber, itemtimestamp, technicalinspectedby, technicalinspectedon, workordernumber, sourcesystemname, transactiontype, inputjson, processed, addts, processedts) VALUES(:accuracy, :activityreason, :additionalinformation, :additionalworkneeded, :assignedengineer, :assignedstart, :assignedend, :backofficereview, :calculatedvolume, :completionstatus, :curbboxmeasurementdescription, :description, :devicecategory, :dials, :dispatchid, :encoderid, :endread, :engineerid, :fsrid, :heattype, :initialrepair, :installation, :lowmedhighindicator, :manufacturerserialnumber, :meterdirectionallocation, :meterpositionlocation, :meterserialnumber, :metersupplementallocation, :miscinvoice, :miunumber, :newread, :notes, :oldmeterserialnumber, :oldread, :operatedpointofcontrol, :operationnumber, :purpose, :qualityissue, :rating, :readingdevicedirectionallocation, :readingdevicepositionallocation, :readingdevicesupplementallocation, :readtype, :registerid, :safety, :serialnumber, :servicefound, :serviceleft, :size, :startread, :statusnonnumber, :statusnotes,:statusnumber, :itemtimestamp, :technicalinspectedby, :technicalinspectedon, :workordernumber, :sourcesystemname, :transactiontype, :inputjson, :processed, :addts, :processedts)", paramSource);
		System.out.println(update);
	}
	
	/*public void addXml(String data) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("xmlfile", data, Types.SQLXML);
		int update = namedTemplate.update("INSERT INTO public.xmlcheck(xmlfile)VALUES (:xmlfile)",paramSource);
		
	}*/
}
