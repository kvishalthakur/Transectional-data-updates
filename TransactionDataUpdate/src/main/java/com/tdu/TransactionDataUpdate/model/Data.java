package com.tdu.TransactionDataUpdate.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Data")
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {

	@XmlElement 
	List<Completion> completion = new ArrayList<Completion>();
	@XmlElement 
	private Update update;
	
	
	public List<Completion> getCompletion() {
		return completion;
	}
	public void setCompletion(List<Completion> completion) {
		this.completion = completion;
	}
	public Update getUpdate() {
		return update;
	}
	public void setUpdate(Update update) {
		this.update = update;
	}
	
	
}
