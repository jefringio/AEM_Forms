package com.silverseatest.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;




@Component(service=Servlet.class,
property={
		Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST,
		"sling.servlet.paths="+ "/bin/check",
		"sling.servlet.extensions=" + "json"
})
public class TestpostServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 1L;
	
	
	@Override
	 protected void doPost(SlingHttpServletRequest req, SlingHttpServletResponse resp)
		      throws ServletException, IOException {
		
		String destination = req.getParameter("dest");
		String date = req.getParameter("date");
		String ship = req.getParameter("ship");
	
		JSONObject obj = new JSONObject();
	
		
		try {
			obj.put("place", destination);
			obj.put("day", date);
			
			obj.put("shipname", ship);
			} 
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");	
		
		resp.getWriter().write(obj.toString());
	
		}

}
