package com.tdu.TransactionDataUpdate.rest;
/*package com.tdu.TransactionDataUpdate.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apporchid.properties.AOPlatformProperties;
import com.apporchid.properties.AOPlatformProperties.IdentityMgmt;
import com.apporchid.security.utils.SecurityUtils;
import com.tdu.TransactionDataUpdate.config.MeterOpsConfigProperties;
import com.tdu.TransactionDataUpdate.constants.CompanyStateFilterConstants;
import com.tdu.TransactionDataUpdate.constants.TDUConstants;
import com.tdu.TransactionDataUpdate.exception.TDUException;
import com.tdu.TransactionDataUpdate.model.UserDetail;
import com.tdu.TransactionDataUpdate.service.SecureService;

@RestController
@RequestMapping(value = "/secure")
public class SecurityController {
	
	@Autowired
	SecureService SecureService;
	
	@Autowired
	private AOPlatformProperties aoPlatformProperties;
	
	@Autowired
	MeterOpsConfigProperties meterOpsConfigProperties;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUserDetails() throws TDUException {
		try {
			OAuth2Authentication authentication = (OAuth2Authentication) SecurityContextHolder.getContext()
					.getAuthentication();
			@SuppressWarnings("unchecked")
			Map<String, String> userDetailsMap = (Map<String, String>) authentication.getUserAuthentication()
					.getDetails();
			log.debug("user details from secure auth {}", userDetailsMap);
			//logging user information
			logUserInfo(userDetailsMap);
			UserDetail user = new UserDetail();
			if (userDetailsMap != null) {
				if (meterOpsConfigProperties.getC1vUserFilterFlag()) {
					if (userDetailsMap.get("GroupMembership") != null) {
						if (userDetailsMap.get("GroupMembership")
								.contains(meterOpsConfigProperties.getC1vUserFilterEnterpriseUser())) {
							user.setMemberOf(meterOpsConfigProperties.getC1vUserFilterEnterpriseUser());
							user.setMeterGroup(meterOpsConfigProperties.getC1vUserFilterEnterpriseUser());
						} else if (userDetailsMap.get("GroupMembership")
								.contains(meterOpsConfigProperties.getC1vUserFilterStateUser())) {
							user.setCompanyName(userDetailsMap.get("Comp"));
							user.setCompany(
									CompanyStateFilterConstants.COMPANY_STATE_MAP.get(userDetailsMap.get("Comp")));
							user.setMemberOf(meterOpsConfigProperties.getC1vUserFilterStateUser());
							user.setMeterGroup(meterOpsConfigProperties.getC1vUserFilterStateUser());
						}
					}
				} else
					user.setMemberOf(meterOpsConfigProperties.getC1vUserFilterEnterpriseUser());

				user.setDisplayName(userDetailsMap.get("DName"));
				user.setUsername(userDetailsMap.get("name"));
				user.setEmail(userDetailsMap.get("UPN"));
			}

			IdentityMgmt identityMgmt = aoPlatformProperties.getSecurity().getIdentitymgmt();
			if (identityMgmt.getAuthType().equalsIgnoreCase("database")) {
				user.setUsername(SecurityUtils.getPrincipal().getUsername());
				return new ResponseEntity<>(setStateEnterprise(user, TDUConstants.DATABASE), HttpStatus.OK);
			} else
				return new ResponseEntity<>(setStateEnterprise(user, ""), HttpStatus.OK);

		} catch (Exception exception) {
			log.error("Exception in getting the user details", exception);
			return new ResponseEntity<>(new TDUException(exception), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	*//**
	 * Method used to log user info
	 * 
	 * @param customerNumber
	 *//*
	@Async("threadPoolTaskExecutor")
	public void logUserInfo(Map<String, String> userDetailsMap) {
		try {
			log.debug("User {}  with id {} logged into MeterOps from the state {} ",
					userDetailsMap.get("DName"), userDetailsMap.get("name"), TDUConstants.COMPANY_MAP.get(userDetailsMap.get("Comp")));
			log.trace("User {}  with id {} logged into MeterOps from the state {} ",
					userDetailsMap.get("DName"), userDetailsMap.get("name"), 
					TDUConstants.COMPANY_MAP.get(userDetailsMap.get("Comp")));
		} catch (Exception e) {
			log.error("Exception while logging the  user info ", e);
		}
	}
	
	private UserDetail setStateEnterprise(UserDetail userDetail, String connection) {
		if (connection.equals(TDUConstants.DATABASE) && userDetail.getUsername().equals("admin")) {
			userDetail.setCompany("NJ");
			userDetail.setStateFullName("New Jersey");
			userDetail.setMeterGroup(meterOpsConfigProperties.getC1vUserFilterEnterpriseUser());
		} else if (userDetail.getMeterGroup() != null
				&& userDetail.getMeterGroup().equals(meterOpsConfigProperties.getC1vUserFilterStateUser()))
			userDetail.setStateFullName(SecureService.getStateName(userDetail.getCompany()));

		return userDetail;
	}
}
*/