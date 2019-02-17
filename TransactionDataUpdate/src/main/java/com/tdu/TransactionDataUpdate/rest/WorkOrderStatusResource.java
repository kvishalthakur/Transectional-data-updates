package com.tdu.TransactionDataUpdate.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tdu.TransactionDataUpdate.model.Parent;
import com.tdu.TransactionDataUpdate.service.WorkOrderStatusService;

@RestController
@RequestMapping(value = "/api")
public class WorkOrderStatusResource {
	
	@Autowired
	WorkOrderStatusService workOrderStatusService;
	
	@PostMapping("/incmwo")
	public ResponseEntity<String> createIncomplateWorkOrder(@RequestBody Parent data) throws Exception {
		workOrderStatusService.saveIncomplateWorkOrder(data);
		return new ResponseEntity<>("success status!", HttpStatus.OK);
	}
	
	@PostMapping("/cmwo")
	public ResponseEntity<String> createComplateWorkOrder(@RequestBody Parent data) throws Exception {

		workOrderStatusService.saveComplateWorkOrder(data);
		return new ResponseEntity<>("success status!", HttpStatus.OK);
	}
}
