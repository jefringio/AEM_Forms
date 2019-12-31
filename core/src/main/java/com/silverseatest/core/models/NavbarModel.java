package com.silverseatest.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NavbarModel {

	@Inject
	private String fileReference;
	
	@Inject
	private String link1;
	
	@Inject
	private String path1;
	
	@Inject
	private String path2;
	
	@Inject
	private String link2;
	
	@Inject
	private String path3;
	
	public String getPath1() {
		return path1;
	}

	public String getPath2() {
		return path2;
	}

	public String getPath3() {
		return path3;
	}

	@Inject
	private String link3;
	
	@Inject
	private String link4;
	
	@Inject
	private String link5;
	
	@Inject
	private String link6;

	public String getLink1() {
		return link1;
	}

	public String getLink2() {
		return link2;
	}

	public String getLink3() {
		return link3;
	}

	public String getLink4() {
		return link4;
	}

	public String getLink5() {
		return link5;
	}

	public String getLink6() {
		return link6;
	}

	public String getFileReference() {
		return fileReference;
	}


	
	
}
