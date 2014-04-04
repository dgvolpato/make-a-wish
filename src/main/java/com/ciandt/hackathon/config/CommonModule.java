package com.ciandt.hackathon.config;

import com.ciandt.hackathon.api.CommonResource;
import com.ciandt.hackathon.dao.GreetingDAO;
import com.ciandt.hackathon.dao.ObjectifyGreetingDAO;
import com.ciandt.hackathon.entity.Greeting;
import com.google.inject.servlet.ServletModule;
import com.googlecode.objectify.ObjectifyService;

public class CommonModule extends ServletModule {

	@Override
	protected void configureServlets() {
		
		bind(CommonResource.class);
		bind(GreetingDAO.class).to(ObjectifyGreetingDAO.class);
		
	}
}
