package com.tdu.TransactionDataUpdate.model;

import java.util.ArrayList;
import java.util.List;

public class Data {

	List<Completion> completion = new ArrayList<Completion>();
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
