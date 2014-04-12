package com.ciandt.hackathon.api;

import java.util.List;

import javax.annotation.concurrent.ThreadSafe;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.ciandt.hackathon.dao.GreetingDAO;
import com.ciandt.hackathon.dao.MesaDAO;
import com.ciandt.hackathon.entity.Greeting;
import com.ciandt.hackathon.entity.Mesa;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Path("/api")
@ThreadSafe
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Singleton
public class CommonResource {

	private final GreetingDAO greetingDAO;
	private final MesaDAO mesaDAO;
	
	@Inject
	public CommonResource(GreetingDAO greetingDAO, MesaDAO mesaDAO) {
		super();
		this.greetingDAO = greetingDAO;
		this.mesaDAO = mesaDAO;
	}

	@GET
	@Path("/listGreetings")
	public List<Greeting> listGreetings(@Context HttpServletRequest request) {
		List<Greeting> listGreetings = greetingDAO.findGreetings();
		return listGreetings;
	}

	@GET
	@Path("/listmesas")
	public List<Mesa> listMesas(@Context HttpServletRequest request) {
		return mesaDAO.findAll();
	}
}
