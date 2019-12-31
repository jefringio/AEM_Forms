package com.silverseatest.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FourColumn {
	
	@Inject
	private Resource fourcolumns;

	public Resource getFourcolumns() {
		return fourcolumns;
	}

	

}
