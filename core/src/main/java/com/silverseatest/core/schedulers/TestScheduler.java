package com.silverseatest.core.schedulers;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.AccessDeniedException;
import javax.jcr.InvalidItemStateException;
import javax.jcr.ItemExistsException;
import javax.jcr.Node;
import javax.jcr.ReferentialIntegrityException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.nodetype.NoSuchNodeTypeException;
import javax.jcr.version.VersionException;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.commons.jcr.JcrUtil;
import com.silverseatest.core.schedulers.SimpleScheduledTask.Config;



@Designate(ocd=TestScheduler.Config.class)		   
@Component(service=Runnable.class)
public class TestScheduler implements Runnable {
	 protected final Logger log = LoggerFactory.getLogger(this.getClass());

	 @ObjectClassDefinition(name="Product Scheduler",
             description = "Create a node called product")
		public static @interface Config {
		
		@AttributeDefinition(name = "Cron-job expression")
		String scheduler_expression() default "*/30 * * * * ?";

		 
		}
	 		
	 @Reference
		private ResourceResolverFactory resourceResolverFactory;
	 
	 
	    @Override
	    public void run() {
	    	log.info("working");
	    	final Map<String, Object> params = new HashMap<>();
			params.put(ResourceResolverFactory.SUBSERVICE, "testing");
			ResourceResolver resourceResolver = null;
			
	    	
			try {
				resourceResolver = resourceResolverFactory.getServiceResourceResolver(params);
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Session session = resourceResolver.adaptTo(Session.class);
		 
		
			try {
				//getting the parentnode and create a node under that
				
				Node parentnode = session.getNode("/conf/silverseatest/sample"); 
				
				try {
					//Creating new node under sample
					
				Node newnode = parentnode.addNode("product","nt:unstructured"); 
				
				//Adding properties to new node
				
				newnode.setProperty("Products", "Fruit");
				newnode.setProperty("Name", "Mango");
				newnode.setProperty("Color", "Green");
				newnode.setProperty("Taste", "Sweet-Bitter");
				
			
				
//				
//				String firstchild = newnode.getPath();
//				log.info("first -"+firstchild);
				
			

			 } catch (Exception e) {
				  log.info(" exception prop");
				  Node exist = parentnode.getNode("product");
				  exist.setProperty("Type", "Organic");
				  
				  
			 } 
			
			session.save();
			 } catch (Exception e) {
				 
			 }
	   
	    }
	    
	    @Activate
	    protected void activate(final Config config) {
	       
	    }
}