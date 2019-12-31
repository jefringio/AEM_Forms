package com.silverseatest.core.models;

import javax.inject.Inject;



import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FooterModel {
	
	@Inject
	private Resource socialbar;

	@Inject
	private String email;
	
//tab2
	
	@Inject
	private String images;
	
	@Inject
	private String title;
	
	@Inject
	private String subheading;
	
	@Inject
	private String buttonname;
	
//tab3 
	
	@Inject
	private String call;
	
	@Inject
	private String contact;
	
	@Inject
	private String next;
	
	@Inject
	private String button;
	
//tab4
	
	@Inject
	private Resource footerlinks;
	
	@Inject
	private Resource sublinks;
	

	

	public Resource getFooterlinks() {
		return footerlinks;
	}

	public Resource getSublinks() {
		return sublinks;
	}

	public String getTitle() {
		return title;
	}

	public Resource getSocialbar() {
		return socialbar;
	}

	public String getSubheading() {
		return subheading;
	}

	public String getButtonname() {
		return buttonname;
	}

	public String getCall() {
		return call;
	}

	public String getContact() {
		return contact;
	}

	public String getButton() {
		return button;
	}

	public String getImages() {
		return images;
	}

	public String getEmail() {
		return email;
	}

	public String getNext() {
		return next;
	}

	
	
	

}
