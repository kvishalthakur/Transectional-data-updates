package com.tdu.TransactionDataUpdate.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Parent {
	private Data data;

	@XmlElement 
	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

}
