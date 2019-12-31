package com.silverseatest.core.listeners;
import javax.jcr.RepositoryException; 
import javax.jcr.Session;
import javax.jcr.observation.Event;
import javax.jcr.observation.EventListener;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;
import com.silverseatest.core.schedulers.TestScheduler;
import com.silverseatest.core.schedulers.SimpleScheduledTask.Config;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.osgi.service.component.ComponentContext; 
import javax.jcr.observation.EventIterator ; 

@Designate(ocd=EventListenerwithemail.Config.class)	
@Component(immediate=true,
service= EventListener.class)
public class EventListenerwithemail  implements EventListener {
	
	 Logger log = LoggerFactory.getLogger(this.getClass());
     private Session Sessions;
     @Reference
     private MessageGatewayService messageGatewayService;
       
      
     @Reference
     org.apache.sling.jcr.api.SlingRepository repository;
     
     
     @ObjectClassDefinition(name="Event Listener with Email",
             description = "Send an email if any chance in any change in the given node")
		public static @interface Config {
		
		@AttributeDefinition(name = "Email - To address")
		String email_to() default "jefrin@au-ki.com";
		
		@AttributeDefinition(name = "Content to be sent")
		String content() default "The node has been Added, Deleted or Updated";

		 
		}
     private String content;
     private  String emailToRecipients;
       
     @Activate
     public void activate(ComponentContext context ,final Config config) throws Exception {
    	 
    	 content = config.content();
    	 emailToRecipients = config.email_to();
    	 
    	 
    	 
     log.info("activating ExampleObservation");
     try {
         Sessions = repository.loginService("testing",null);
         Sessions.getWorkspace().getObservationManager().addEventListener(
          this, 
          Event.PROPERTY_ADDED|Event.NODE_ADDED|Event.NODE_REMOVED|Event.PROPERTY_REMOVED, 
          "/content/silverseatest/listener-page", 
          true, 
          null, 
          null, 
          false);
       
           
     } catch (RepositoryException e){
      log.error("unable to register session",e);
      throw new Exception(e);
     }
    }
    @Deactivate
    public void deactivate(){
     if (Sessions != null){
      Sessions.logout();
     }
    }
       
    public void onEvent(EventIterator eventIterator) {
      try {
    	
        while (eventIterator.hasNext()){
        	
        	MessageGateway<Email> messageGateway;

            Email email = new SimpleEmail();

             
            try {
		            email.addTo(emailToRecipients);
		            System.out.println("email "+ emailToRecipients);
			
		            email.setSubject("AEM Custom Step");
		
		            email.setFrom("jefringio200@gmail.com");
		
		            email.setMsg(content);

				} catch(Exception e){
				    log.error("Error while treating events",e);
				   }

            messageGateway = messageGatewayService.getGateway(Email.class);
            messageGateway.send((Email) email);
            
          log.info("something has been added : {}", eventIterator.nextEvent().getPath());
          System.out.println("test");
        }
       } catch(RepositoryException e){
       log.error("Error while treating events",e);
      }
     }

}
