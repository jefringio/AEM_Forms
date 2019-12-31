package com.silverseatest.core.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.mail.EmailException;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Reference;

import com.day.commons.datasource.poolservice.DataSourcePool;
import com.silverseatest.core.service.DisplayDataService;

public class DisplayDataImpl implements DisplayDataService {
	
	  @Reference
	    private DataSourcePool source;
	JSONObject returnObj=null;
	
	  Connection c = null;
	  public  JSONObject getDataFromDB() throws SQLException {
       
      try {
                        
            // Create a Connection object
            c =  getConnection();
            
             PreparedStatement ps = null; 
             ResultSet result = null;
               
             String sql = "SELECT * FROM userdetails;";
             ps = c.prepareStatement(sql);
             result= ps.executeQuery();
             
             JSONObject returnObj = new JSONObject();
             
     		int inc = 0;
     		
     		while (result.next()) {
     			String id = result.getString(1);
    			String name = result.getString(2);
    			String email = result.getString(3);
    			String subject = result.getString(4);
    			String message = result.getString(5);
    			String status = result.getString(6);
    	
    			JSONObject jsonobject = new JSONObject();
    			try {
	    			
	    			jsonobject.put("id", id);
    				jsonobject.put("name", name);
    				jsonobject.put("email", email);
    				jsonobject.put("subject", subject);
    				jsonobject.put("message", message);
    				jsonobject.put("status", status);
    				
    				
    				returnObj.put(Integer.toString(inc), jsonobject);
    			} catch (JSONException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			
    			inc++;
     		}
    		
              
      }
      catch (Exception e) {
        e.printStackTrace();
       }
      finally {
        try
        {
          c.close();
        }
          
          catch (SQLException e) {
            e.printStackTrace();
          }
  }
	return returnObj;
     
      
}

//Returns a connection using the configured DataSourcePool 
  private Connection getConnection()
  {
           DataSource dataSource = null;
           Connection con = null;
           try
           {
               //Inject the DataSourcePool right here! 
               dataSource = (DataSource) source.getDataSource("WeRetailMySQL");
               con = dataSource.getConnection();
               return con;
                 
             }
           catch (Exception e)
           {
               e.printStackTrace(); 
           }
               return null; 
  }
         
}
