package com.silverseatest.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class FirstHero {

	@Inject
	private String title;
	
	@Inject
	private String fileReference;

	@Inject
	private String subheading;
	
	@Inject
	private String link;
	
	@Inject
	private String description;

	public String getFileReference() {
		return fileReference;
	}
	
	public String getDescription() {
		return description;
	}

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

