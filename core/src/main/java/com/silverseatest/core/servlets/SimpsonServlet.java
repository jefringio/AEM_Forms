package com.silverseatest.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.silverseatest.core.service.SimpsonService;

@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=Simpson Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths="+ "/bin/example",
        "sling.servlet.extensions=" + "json"
})

public class SimpsonServlet extends SlingSafeMethodsServlet  {

	private static final long serialVersionUID = 1L;
	
	@Reference
	private SimpsonService Simpson;
 
    @Override
    protected void doGet(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp) throws ServletException, IOException {
    	
    	
	    	String extension = req.getParameter("simpson");
	   
	    	String apiresponse = Simpson.ApiCall(extension);
	    	String str = apiresponse.substring(apiresponse.indexOf('[')+1, apiresponse.indexOf(']'));
	    	
	    	
	    	final ObjectMapper mapper = new ObjectMapper();
			final JsonNode jn = mapper.readTree(str);
			
			JSONObject obj = new JSONObject();
	    	
    		try {
    
				obj.put("quote", jn.get("quote").asText());
				obj.put("character", jn.get("character").asText());
				obj.put("image", jn.get("image").asText());
				obj.put("characterdirection", jn.get("characterDirection").asText());

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	
	    
    		resp.setContentType("application/json");
 	        resp.setCharacterEncoding("utf-8");
    		resp.getWriter().write(str.toString());
    		
    		
    		
        
    }
}