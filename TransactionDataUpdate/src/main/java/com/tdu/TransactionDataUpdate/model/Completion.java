package com.tdu.TransactionDataUpdate.model;

import java.util.List;

public class Completion {

	private String workOrderNumber;
	private String miscInvoice;
	private String backOfficeReview;
	private String completionStatus;
	private String notes;
	
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	private List<Activities> activities;
	
	private String additionalWorkNeeded;
	private String purpose;
	private String technicalInspectedOn;
	private String technicalInspectedBy;
	private String serviceFound;
	private String serviceLeft;
	private String operatedPointOfControl;
	private String additionalInformation;
	private String curbBoxMeasurementDescription;
	private String safety;
	private String heatType;
	private String meterPositionLocation;
	private String meterDirectionalLocation;
	private String meterSupplementalLocation;
	private String readingDevicePositionalLocation;
	private String readingDeviceSupplementalLocation;
	private String readingDeviceDirectionalLocation;
	private String fSRId;
	private String serialNumber;
	private String oldMeterSerialNumber;
	
	private List<Registers> registers;
	
	private String meterSerialNumber;
	private String manufacturerSerialNumber;
	private String deviceCategory;
	private String installation;
	private String actionFlag;
	private String activityReason;
	private String rating;
	private String qualityIssue;
	private List<TestResults> testResults;
	
	public String getQualityIssue() {
		return qualityIssue;
	}

	public void setQualityIssue(String qualityIssue) {
		this.qualityIssue = qualityIssue;
	}

	public String getWorkOrderNumber() {
		return workOrderNumber;
	}

	public void setWorkOrderNumber(String workOrderNumber) {
		this.workOrderNumber = workOrderNumber;
	}

	public String getMiscInvoice() {
		return miscInvoice;
	}

	public void setMiscInvoice(String miscInvoice) {
		this.miscInvoice = miscInvoice;
	}

	public String getBackOfficeReview() {
		return backOfficeReview;
	}

	public void setBackOfficeReview(String backOfficeReview) {
		this.backOfficeReview = backOfficeReview;
	}

	public String getCompletionStatus() {
		return completionStatus;
	}

	public void setCompletionStatus(String completionStatus) {
		this.completionStatus = completionStatus;
	}

	public List<Activities> getActivities() {
		return activities;
	}

	public void setActivities(List<Activities> activities) {
		this.activities = activities;
	}

	public String getAdditionalWorkNeeded() {
		return additionalWorkNeeded;
	}

	public void setAdditionalWorkNeeded(String additionalWorkNeeded) {
		this.additionalWorkNeeded = additionalWorkNeeded;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getTechnicalInspectedOn() {
		return technicalInspectedOn;
	}

	public void setTechnicalInspectedOn(String technicalInspectedOn) {
		this.technicalInspectedOn = technicalInspectedOn;
	}

	public String getTechnicalInspectedBy() {
		return technicalInspectedBy;
	}

	public void setTechnicalInspectedBy(String technicalInspectedBy) {
		this.technicalInspectedBy = technicalInspectedBy;
	}

	public String getServiceFound() {
		return serviceFound;
	}

	public void setServiceFound(String serviceFound) {
		this.serviceFound = serviceFound;
	}

	public String getServiceLeft() {
		return serviceLeft;
	}

	public void setServiceLeft(String serviceLeft) {
		this.serviceLeft = serviceLeft;
	}

	public String getOperatedPointOfControl() {
		return operatedPointOfControl;
	}

	public void setOperatedPointOfControl(String operatedPointOfControl) {
		this.operatedPointOfControl = operatedPointOfControl;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public String getCurbBoxMeasurementDescription() {
		return curbBoxMeasurementDescription;
	}

	public void setCurbBoxMeasurementDescription(String curbBoxMeasurementDescription) {
		this.curbBoxMeasurementDescription = curbBoxMeasurementDescription;
	}

	public String getSafety() {
		return safety;
	}

	public void setSafety(String safety) {
		this.safety = safety;
	}

	public String getHeatType() {
		return heatType;
	}

	public void setHeatType(String heatType) {
		this.heatType = heatType;
	}

	public String getMeterPositionLocation() {
		return meterPositionLocation;
	}

	public void setMeterPositionLocation(String meterPositionLocation) {
		this.meterPositionLocation = meterPositionLocation;
	}

	public String getMeterDirectionalLocation() {
		return meterDirectionalLocation;
	}

	public void setMeterDirectionalLocation(String meterDirectionalLocation) {
		this.meterDirectionalLocation = meterDirectionalLocation;
	}

	public String getMeterSupplementalLocation() {
		return meterSupplementalLocation;
	}

	public void setMeterSupplementalLocation(String meterSupplementalLocation) {
		this.meterSupplementalLocation = meterSupplementalLocation;
	}

	public String getReadingDevicePositionalLocation() {
		return readingDevicePositionalLocation;
	}

	public void setReadingDevicePositionalLocation(String readingDevicePositionalLocation) {
		this.readingDevicePositionalLocation = readingDevicePositionalLocation;
	}

	public String getReadingDeviceSupplementalLocation() {
		return readingDeviceSupplementalLocation;
	}

	public void setReadingDeviceSupplementalLocation(String readingDeviceSupplementalLocation) {
		this.readingDeviceSupplementalLocation = readingDeviceSupplementalLocation;
	}

	public String getReadingDeviceDirectionalLocation() {
		return readingDeviceDirectionalLocation;
	}

	public void setReadingDeviceDirectionalLocation(String readingDeviceDirectionalLocation) {
		this.readingDeviceDirectionalLocation = readingDeviceDirectionalLocation;
	}

	public String getfSRId() {
		return fSRId;
	}

	public void setfSRId(String fSRId) {
		this.fSRId = fSRId;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getOldMeterSerialNumber() {
		return oldMeterSerialNumber;
	}

	public void setOldMeterSerialNumber(String oldMeterSerialNumber) {
		this.oldMeterSerialNumber = oldMeterSerialNumber;
	}

	public List<Registers> getRegisters() {
		return registers;
	}

	public void setRegisters(List<Registers> registers) {
		this.registers = registers;
	}

	public String getMeterSerialNumber() {
		return meterSerialNumber;
	}

	public void setMeterSerialNumber(String meterSerialNumber) {
		this.meterSerialNumber = meterSerialNumber;
	}

	public String getManufacturerSerialNumber() {
		return manufacturerSerialNumber;
	}

	public void setManufacturerSerialNumber(String manufacturerSerialNumber) {
		this.manufacturerSerialNumber = manufacturerSerialNumber;
	}

	public String getDeviceCategory() {
		return deviceCategory;
	}

	public void setDeviceCategory(String deviceCategory) {
		this.deviceCategory = deviceCategory;
	}

	public String getInstallation() {
		return installation;
	}

	public void setInstallation(String installation) {
		this.installation = installation;
	}

	public String getActionFlag() {
		return actionFlag;
	}

	public void setActionFlag(String actionFlag) {
		this.actionFlag = actionFlag;
	}

	public String getActivityReason() {
		return activityReason;
	}

	public void setActivityReason(String activityReason) {
		this.activityReason = activityReason;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public List<TestResults> getTestResults() {
		return testResults;
	}

	public void setTestResults(List<TestResults> testResults) {
		this.testResults = testResults;
	}
	
	
	
}