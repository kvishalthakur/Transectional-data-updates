package com.tdu.TransactionDataUpdate.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping(value = "/workOrder")
public class WorkOrderStatusResource {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	WorkOrderStatusService workOrderStatusService;
	
	@PostMapping("/w1vTxnData")
	public ResponseEntity<String> createW1vTxnData(@RequestBody Parent data) {
		int status = 0;
		try {
			status = workOrderStatusService.saveW1vTxnData(data);
		} catch (Exception e) {
			log.error("Getting exception in wo status service "+e);
			return new ResponseEntity<>("Getting exception in service!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(status == 1) {
			return new ResponseEntity<>("Data updated successfully!", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Record not inserted!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
