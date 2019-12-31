package com.silverseatest.core.models;

import javax.inject.Inject;



import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class YoutubeCompModel {

	
	@Inject
	private String title;
	
	@Inject
	private String subheading;
	
	@Inject
	private String link;

	public String getTitle() {
		return title;
	}

	public String getSubheading() {
		return subheading;
	}

	public String getLink() {
		return link.substring(link.indexOf("=") + 1);
	}


	

	
	
}
