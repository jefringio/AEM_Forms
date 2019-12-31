package com.silverseatest.core.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public interface SimpsonService {
	public String ApiCall(String value) throws ClientProtocolException, IOException;

}
