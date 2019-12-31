package com.silverseatest.core.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.osgi.framework.Constants;


import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.silverseatest.core.service.DisplayDataService;

@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=Form Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths="+ "/bin/aemform3",
        "sling.servlet.extensions=" + "json"
})
public class DisplayGetServlet extends SlingSafeMethodsServlet  {

	private static final long serialVersionUID = 1L;
	
	@Reference
	private DisplayDataService displayDataService;
	
	@Override
    protected void doGet(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp) throws ServletException, IOException  {
	    	

			
			JSONObject returnObj= null;
			try {
//				returnObj.put("ss","sd");
				returnObj = displayDataService.getDataFromDB();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    
    		resp.setContentType("application/json");
 	        resp.setCharacterEncoding("utf-8");
    		resp.getWriter().write(returnObj.toString());

	
	}
}
