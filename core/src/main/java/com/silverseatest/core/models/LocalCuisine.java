package com.silverseatest.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LocalCuisine {
	
	@Inject
	private String preheading;
	
	@Inject
	private String title;
	

	@Inject
	private String description;

	
	public String getPreheading() {
		return preheading;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}


}
