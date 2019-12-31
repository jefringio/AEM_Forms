package com.silverseatest.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BeforeYouGo {
	
	@Inject
	private String preheading;
	
	@Inject
	private String title;
	
	
	@Inject
	private String subheading;
	
	@Inject
	private String description;

	@Inject
	private Resource multiplecolumn;
	

	public String getPreheading() {
		return preheading;
	}

	public String getTitle() {
		return title;
	}

	public String getSubheading() {
		return subheading;
	}

	public String getDescription() {
		return description;
	}

	public Resource getMultiplecolumn() {
		return multiplecolumn;
	}

}
