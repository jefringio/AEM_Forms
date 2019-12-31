package com.silverseatest.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BahamasCarousel {
	@Inject
	private String text1;
	
	@Inject
	private String text2;
	
	@Inject
	private String text3;
	
	@Inject
	private String text4;
	
	@Inject
	private String text5;

	@Inject
	private Resource image1;
	
	@Inject
	private Resource image2;
	
	@Inject
	private Resource image3;
	
	@Inject
	private Resource image4;
	
	@Inject
	private Resource image5;

	public String getText1() {
		return text1;
	}

	public String getText2() {
		return text2;
	}

	public String getText3() {
		return text3;
	}

	public String getText4() {
		return text4;
	}

	public String getText5() {
		return text5;
	}

	public Resource getImage1() {
		return image1;
	}

	public Resource getImage2() {
		return image2;
	}

	public Resource getImage3() {
		return image3;
	}

	public Resource getImage4() {
		return image4;
	}

	public Resource getImage5() {
		return image5;
	}
	

}
