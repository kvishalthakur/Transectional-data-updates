package com.tdu.TransactionDataUpdate.service;

import java.io.StringWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tdu.TransactionDataUpdate.dao.WorkOrderStatusDao;
import com.tdu.TransactionDataUpdate.model.Activities;
import com.tdu.TransactionDataUpdate.model.Completion;
import com.tdu.TransactionDataUpdate.model.Data;
import com.tdu.TransactionDataUpdate.model.Parent;
import com.tdu.TransactionDataUpdate.model.Registers;
import com.tdu.TransactionDataUpdate.model.Update;

@Service
public class WorkOrderStatusService {

	@Autowired
	WorkOrderStatusDao workOrderStatusDao;
	List<Map<String,String>> completionList = null;
	
	public int saveW1vTxnData(Parent prt) throws Exception{
		int status = 0;
		String xmlData = convertJsonToXML(prt);
		List<Map<String, String>> incomCompletionList = parseJson(prt);
		for(Map<String, String> trnData : incomCompletionList) {
			status = workOrderStatusDao.saveW1vTxnData(trnData, xmlData);
		}
		return status;
	}

	private List<Map<String,String>> parseJson(Parent prt) {
		
		completionList = new ArrayList<>();
		for(Completion comp : prt.getData().getCompletion()) {
		String discription = "";
		Integer i = 0;
		Map<String,String> trnData = new HashMap<>();
			
		trnData.put("purpose", comp.getPurpose());
		trnData.put("actionFlag", comp.getActionFlag());
		trnData.put("activityReason", comp.getActivityReason());
		trnData.put("additionalInformation", comp.getAdditionalInformation());
		trnData.put("additionalWorkNeeded", comp.getAdditionalWorkNeeded());
		trnData.put("backOfficeReview", comp.getBackOfficeReview());
		trnData.put("completionStatus", comp.getCompletionStatus());
		
		if(comp.getCompletionStatus().equalsIgnoreCase("INCM")) {
			trnData.put("transactiontype", "incomlete");
		}else if(comp.getCompletionStatus().equalsIgnoreCase("COMP")) {
			trnData.put("transactiontype", "comlete");	
		}
		
		trnData.put("curbBoxMeasurementDescription", comp.getCurbBoxMeasurementDescription());
		trnData.put("deviceCategory", comp.getDeviceCategory());
		trnData.put("fsrId", comp.getfSRId());
		trnData.put("heatType", comp.getHeatType());
		trnData.put("installation", comp.getInstallation());
		trnData.put("manufacturerSerialNumber", comp.getManufacturerSerialNumber());
		trnData.put("meterDirectionalLocation", comp.getMeterDirectionalLocation());
		trnData.put("meterPositionLocation", comp.getMeterPositionLocation());
		trnData.put("meterSerialNumber", comp.getMeterSerialNumber());
		trnData.put("meterSupplementalLocation", comp.getMeterSupplementalLocation());
		trnData.put("miscInvoice", comp.getMiscInvoice());
		trnData.put("notes", comp.getNotes());
		trnData.put("oldMeterSerialNumber", comp.getOldMeterSerialNumber());
		trnData.put("operatedPointOfControl", comp.getOperatedPointOfControl());
		trnData.put("qualityIssue", comp.getQualityIssue());
		trnData.put("rating", comp.getRating());
		trnData.put("readingDeviceDirectionalLocation", comp.getReadingDeviceDirectionalLocation());
		
		trnData.put("readingDevicePositionalLocation", comp.getReadingDevicePositionalLocation());
		trnData.put("readingDeviceSupplementalLocation", comp.getReadingDeviceSupplementalLocation());
		trnData.put("safety", comp.getSafety());
		trnData.put("serialNumber", comp.getSerialNumber());
		trnData.put("serviceFound", comp.getServiceFound());
		trnData.put("serviceLeft", comp.getServiceLeft());
		trnData.put("technicalInspectedBy", comp.getTechnicalInspectedBy());
		trnData.put("technicalInspectedOn", convertDateFormat(comp.getTechnicalInspectedOn()));
		trnData.put("workOrderNumber", comp.getWorkOrderNumber());
		
		
		List<Registers> registersList = comp.getRegisters();
		
		if(registersList.size()>= 1) {
		trnData.put("r1dials", registersList.get(0).getDials());
		trnData.put("r1encoderId", registersList.get(0).getEncoderId());
		trnData.put("r1mIUNumber", registersList.get(0).getmIUNumber());
		trnData.put("r1newRead", registersList.get(0).getNewRead());
		trnData.put("r1oldRead", registersList.get(0).getOldRead());
		trnData.put("r1readType", registersList.get(0).getReadType());
		trnData.put("r1size", registersList.get(0).getSize());
		}
		
		if(registersList.size()>= 2) {
		trnData.put("r2dials", registersList.get(1).getDials());
		trnData.put("r2encoderId", registersList.get(1).getEncoderId());
		trnData.put("r2mIUNumber", registersList.get(1).getmIUNumber());
		trnData.put("r2newRead", registersList.get(1).getNewRead());
		trnData.put("r2oldRead", registersList.get(1).getOldRead());
		trnData.put("r2readType", registersList.get(1).getReadType());
		trnData.put("r2size", registersList.get(1).getSize());
		}
		
		List<Activities> activitiesList = comp.getActivities();
		
		for(Activities act: activitiesList) {
			++i;
			if(activitiesList.size() == i){
				discription = discription.concat(act.getDescription());
			}else {
				discription = discription.concat(act.getDescription()).concat(",");
			}
		}
		trnData.put("descriptions", discription);
		Update update = prt.getData().getUpdate();
		
		trnData.put("assignedEngineer", update.getAssignedEngineer());
		trnData.put("assignmentEnd", getTimeStamp(update.getAssignmentEnd()));
		trnData.put("assignmentStart", getTimeStamp(update.getAssignmentStart()));
		trnData.put("dispatchId", update.getDispatchId());
		trnData.put("engineerId", update.getEngineerId());
		trnData.put("itemTimeStamp", getTimeStamp(update.getItemTimeStamp()));
		trnData.put("operationNumber", update.getOperationNumber());
		trnData.put("statusNonNumber", update.getStatusNonNumber());
		trnData.put("statusNotes", update.getStatusNotes());
		trnData.put("statusNumber", update.getStatusNumber());
		
		completionList.add(trnData);
	}
		return completionList;
  }
	
 private String convertJsonToXML(Parent prt) throws JAXBException, PropertyException {
		JAXBContext contextObj = JAXBContext.newInstance(Data.class);  
		  
	    Marshaller marshallerObj = contextObj.createMarshaller();  
	    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
	  
	    StringWriter sw = new StringWriter();
	    marshallerObj.marshal(prt.getData(), sw);
	    String string = sw.toString();
		return string;
	}
 
 private static String getTimeStamp(String givenDate) {
	  Date date=null;
	  Timestamp ts = null;
	try {
		date = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss").parse(givenDate);
		ts =new Timestamp(date.getTime());
	} catch (ParseException e) {
		System.out.println("Getting Exception while converting date to timestamp"+e);
	}
	return ts.toString();
 }
 
 private static String convertDateFormat(String givenDate) {
	 String reformattedStr = null;
	 SimpleDateFormat fromUser = new SimpleDateFormat("yyyyMMdd");
	  SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
	  try {
		  reformattedStr = myFormat.format(fromUser.parse(givenDate));
	  System.out.println(reformattedStr);
	  } catch (ParseException e) {
		  System.out.println(e);
	  }
	  return reformattedStr;
}
 
}
