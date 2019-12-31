package com.silverseatest.core.serviceimpl;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.osgi.service.component.annotations.Component;


import com.silverseatest.core.service.SimpsonService;


@Component(service = SimpsonService.class, immediate=true)
public class SimpsonImpl implements SimpsonService {

	@Override
	public String ApiCall(String param) throws ClientProtocolException, IOException  {
		
		return
			Request.Get("https://thesimpsonsquoteapi.glitch.me/quotes?count=" + param)
	        .connectTimeout(1000)
	        .socketTimeout(1000)
	        .execute().returnContent().asString();
		
}
}
