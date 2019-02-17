package com.tdu.TransactionDataUpdate.service;

import java.io.StringWriter;
import java.util.ArrayList;
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
import com.tdu.TransactionDataUpdate.model.Parent;
import com.tdu.TransactionDataUpdate.model.Registers;
import com.tdu.TransactionDataUpdate.model.TestResults;
import com.tdu.TransactionDataUpdate.model.Update;

@Service
public class WorkOrderStatusService {

	@Autowired
	WorkOrderStatusDao workOrderStatusDao;
	List<Map<String,String>> completionList = null;
	
	public void saveIncomplateWorkOrder(Parent prt) throws Exception{
		String xmlData = convertJsonToXML(prt);
		List<Map<String, String>> incomCompletionList = parseJson(prt);
		for(Map<String, String> trnData : incomCompletionList) {
			workOrderStatusDao.saveIncomplateWorkOrder(trnData, xmlData);
		}
	}
	
	public void saveComplateWorkOrder(Parent prt) throws Exception{
		String xmlData = convertJsonToXML(prt);
		List<Map<String, String>> incomCompletionList = parseJson(prt);
		for(Map<String, String> trnData : incomCompletionList) {
			workOrderStatusDao.saveComplateWorkOrder(trnData, xmlData);
		}
	}

	private List<Map<String,String>> parseJson(Parent prt) {
		
		completionList = new ArrayList<>();
		for(Completion comp : prt.getData().getCompletion()) {
		
		Map<String,String> trnData = new HashMap<>();
			
		trnData.put("purpose", comp.getPurpose());
		trnData.put("actionFlag", comp.getActionFlag());
		trnData.put("activityReason", comp.getActivityReason());
		trnData.put("additionalInformation", comp.getAdditionalInformation());
		trnData.put("additionalWorkNeeded", comp.getAdditionalWorkNeeded());
		trnData.put("backOfficeReview", comp.getBackOfficeReview());
		trnData.put("completionStatus", comp.getCompletionStatus());
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
		trnData.put("technicalInspectedOn", comp.getTechnicalInspectedOn());
		trnData.put("workOrderNumber", comp.getWorkOrderNumber());
		
		List<Registers> registersList = comp.getRegisters();
		Registers registers = registersList.get(0);
		trnData.put("dials", registers.getDials());
		trnData.put("encoderId", registers.getEncoderId());
		trnData.put("mIUNumber", registers.getmIUNumber());
		trnData.put("newRead", registers.getNewRead());
		trnData.put("oldRead", registers.getOldRead());
		trnData.put("readType", registers.getReadType());
		trnData.put("size", registers.getSize());
		
		
		List<TestResults> testResultsList = comp.getTestResults();
		TestResults testResults = testResultsList.get(0);
		trnData.put("accuracy", testResults.getAccuracy());
		trnData.put("calculatedVolume", testResults.getCalculatedVolume());
		trnData.put("endRead", testResults.getEndRead());
		trnData.put("initialRepair", testResults.getInitialRepair());
		trnData.put("lowMedHighIndicator", testResults.getLowMedHighIndicator());
		trnData.put("registerId", testResults.getRegisterId());
		trnData.put("startRead", testResults.getStartRead());
		trnData.put("testFlowRate", testResults.getTestFlowRate());
		
		List<Activities> activitiesList = comp.getActivities();
		Activities activities = activitiesList.get(0);
		
		Update update = prt.getData().getUpdate();
		
		trnData.put("assignedEngineer", update.getAssignedEngineer());
		trnData.put("assignmentEnd", update.getAssignmentEnd());
		trnData.put("assignmentStart", update.getAssignmentStart());
		trnData.put("dispatchId", update.getDispatchId());
		trnData.put("engineerId", update.getEngineerId());
		trnData.put("itemTimeStamp", update.getItemTimeStamp());
		trnData.put("operationNumber", update.getOperationNumber());
		trnData.put("statusNonNumber", update.getStatusNonNumber());
		trnData.put("statusNotes", update.getStatusNotes());
		trnData.put("statusNumber", update.getStatusNumber());
		trnData.put("workOrderNumber", update.getWorkOrderNumber());
		
		trnData.put("description", activities.getDescription());
		
		completionList.add(trnData);
	}
		return completionList;
  }
	
 private String convertJsonToXML(Parent prt) throws JAXBException, PropertyException {
		JAXBContext contextObj = JAXBContext.newInstance(Parent.class);  
		  
	    Marshaller marshallerObj = contextObj.createMarshaller();  
	    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
	  
	    StringWriter sw = new StringWriter();
	    marshallerObj.marshal(prt, sw);
	    String string = sw.toString();
		return string;
	}
}
