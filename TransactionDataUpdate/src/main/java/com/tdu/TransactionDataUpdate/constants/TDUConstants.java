package com.tdu.TransactionDataUpdate.constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TDUConstants {
	public static final Map<String, String> COMPANY_MAP;
	public static final String DATABASE = "DATABASE";
	
	static {
		Map<String, String> comapanyMap = new HashMap<>();

		comapanyMap.put("Arizona American Water Company", "AZ");
		comapanyMap.put("California American Water Company", "CA");
		comapanyMap.put("California-American Water Co.", "CA");
		comapanyMap.put("Hawaii American Water Company", "HI");
		comapanyMap.put("Illinois American Water Company", "IL");
		comapanyMap.put("Indiana American Water Company", "IN");
		comapanyMap.put("Iowa American Water Company", "IA");
		comapanyMap.put("Kentucky American Water Company", "KY");
		comapanyMap.put("Maryland American Water Company", "MD");
		comapanyMap.put("Michigan American Water Company", "MI");
		comapanyMap.put("Missouri American Water Company", "MO");
		comapanyMap.put("Missouri-American Water Co.", "MO");
		comapanyMap.put("New Jersey American Water", "NJ");
		comapanyMap.put("New Jersey American Water Company", "NJ");
		comapanyMap.put("New Mexico American Water", "NM");
		comapanyMap.put("New Mexico American Water Company", "NM");
		comapanyMap.put("New York American Water Company", "NY");
		comapanyMap.put("NY American Water (Merrick/Sea Cliff)", "NY");
		comapanyMap.put("Ohio American Water Company", "OH");
		comapanyMap.put("Ohio-American Water Co.", "OH");
		comapanyMap.put("Pennsylvania American Water Co", "PA");
		comapanyMap.put("Pennsylvania American Water Company", "PA");
		comapanyMap.put("Tennessee American Water Company", "TN");
		comapanyMap.put("Texas American Water Company", "TX");
		comapanyMap.put("West Virginia American Water Company", "WV");
		comapanyMap.put("Virginia American Water Company", "VA");
		COMPANY_MAP = Collections.unmodifiableMap(comapanyMap);
	}
}
