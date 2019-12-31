package com.silverseatest.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;


import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Dropdown {

	@Inject
	private Resource destination;
	
	@Inject
	private Resource dates;
	
	@Inject
	private Resource ships;
	
	
	public Resource getDestination() {
		return destination;
		}
	public Resource getDates() {
		return dates;
		}
	public Resource getShips() {
		return ships;
		}
}
