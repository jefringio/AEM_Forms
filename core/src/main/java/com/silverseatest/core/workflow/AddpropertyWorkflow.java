package com.silverseatest.core.workflow;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.HashMap;
import java.util.Map;



@Component(service = WorkflowProcess.class,  
immediate = true, enabled = true,
property = {"process.label= Metadata Property Update"})


public class AddpropertyWorkflow implements WorkflowProcess{
	
	
	@Reference
	private ResourceResolverFactory resourceResolverFactory; 
	
	
	@Override
	public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap args) throws WorkflowException {
		
		
		String path = workItem.getWorkflowData().getPayload().toString();
		String workflowPath = path.substring(0, path.lastIndexOf("/")-10)+"metadata";
		System.out.println(workflowPath);

		final Map<String, Object> params = new HashMap<>();
		params.put(ResourceResolverFactory.SUBSERVICE, "testing");
		ResourceResolver resourceResolver = null;
		
		try {
			resourceResolver = resourceResolverFactory.getServiceResourceResolver(params);
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
        Resource metadata = resourceResolver.getResource(workflowPath);
        ModifiableValueMap prop = metadata.adaptTo(ModifiableValueMap.class);
        prop.put("360 degree", "true");
        
        try {
			metadata.getResourceResolver().commit();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       


	}
}


