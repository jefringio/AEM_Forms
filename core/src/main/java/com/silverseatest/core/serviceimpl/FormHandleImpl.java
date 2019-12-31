package com.silverseatest.core.serviceimpl;

import org.apache.commons.mail.EmailException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.engine.EngineConstants;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import java.util.Properties;
 

//Add the DataSourcePool package
import com.day.commons.datasource.poolservice.DataSourcePool;
import com.silverseatest.core.service.FormHandleService;
import com.silverseatest.core.service.MailService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
  
  
import java.sql.SQLException;
import javax.sql.DataSource;
 
@Component
public class FormHandleImpl implements FormHandleService{
     
    /** Default log. */
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
     
    @Reference
    private DataSourcePool source;
    
    @Reference
    private MailService mailService;
  
    //Inject the Form Data into a database! 
    @Override
    public void injestFormDataDB(String name, String email, String subject, String message){
         
        //Simply write out the values that are posted from the AEM form to the AEM log file
        log.info("DB Data posted from an AEM adaptive form - customer_ID: "+name +" customer_Name: "+email +" customer_Shipping_Address: "+subject +" customer_State "+message) ;
         
        Connection c = null;
         
        int rowCount= 0; 
        try {
                          
              // Create a Connection object
              c =  getConnection();
             
               ResultSet rs = null;
               Statement s = c.createStatement();
               Statement scount = c.createStatement();
                   
               //Use prepared statements to protected against SQL injection attacks
               PreparedStatement pstmt = null;
               PreparedStatement ps = null; 
                             
             
               String insert = "INSERT INTO userdetails( name, email, subject, message,status) VALUES(?, ?,?,?,?);";
               ps = c.prepareStatement(insert);
                 
               
               ps.setString(1, name);
               ps.setString(2, email);
               ps.setString(3, subject);
               ps.setString(4, message);
               ps.setString(5, "Mail not sent");
               ps.execute();
                
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
        try {
    		mailService.sendMail(email, subject, "Thank You");
    		
    	} catch (EmailException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
        
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
