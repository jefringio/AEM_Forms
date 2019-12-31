package com.silverseatest.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class InsiderTips {
	
	@Inject
	private String fileReference;
	
	@Inject
	private String title;
	
	@Inject
	private Resource numbercolumn;

	public String getFileReference() {
		return fileReference;
	}

	public String getTitle() {
		return title;
	}

	public Resource getNumbercolumn() {
		return numbercolumn;
	}

}
