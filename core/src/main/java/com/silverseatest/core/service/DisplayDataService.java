package com.silverseatest.core.service;

import java.sql.SQLException;

import org.json.JSONObject;

public interface DisplayDataService {
	
	 public  JSONObject getDataFromDB()  throws SQLException;
}
