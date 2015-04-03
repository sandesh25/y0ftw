package com.system.user.service;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.model.wadl.Description;
import org.apache.cxf.jaxrs.model.wadl.DocTarget;

import com.system.user.model.User;

@Path("/UserService")
@WebService
public interface UserService {
	
	@POST
	@Path("/login")
	@Description(value="Resource",target=DocTarget.RESOURCE)
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN,MediaType.APPLICATION_FORM_URLENCODED})
	public User login(@FormParam("username") @WebParam(name = "username") String username, @FormParam("password")  @WebParam(name = "password") String password);
	
	@POST
	@Path("/addUser")
	@Description(value="Resource",target=DocTarget.RESOURCE)
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN})
	public User addUser(@WebParam(name = "newUser") User user);
}
