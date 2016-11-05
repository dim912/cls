package com.dim.cls.rs.resource;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dim.cls.model.LoginProfile;
import com.dim.cls.model.StaffMember;
import com.dim.cls.model.abstracts.AbstractPerson;
import com.dim.cls.pay.dao.api.UserDao;
import com.dim.cls.pay.dao.impl.UserDaoImpl;
import com.dim.cls.user.UserService;
import com.dim.cls.user.impl.UserServiceImpl;

//JAXRS annotation	
@Path("person") 
@Component
public class PersonResource {
	
	@Autowired
	UserService userService;
	
	//get called for GetRequst
	@GET
	//out put type of this method
	//@Produces(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_XML)
	public List<StaffMember> getAllStaffMembers(){	
		return userService.findAll();		
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public StaffMember getStaffMember(@PathParam("id") long idInternal){
		System.out.println(idInternal);
		StaffMember s =  userService.findById(idInternal)	;
		return s;
	}
	
	
	@POST
	//this method consumes the json send on body of the message
	@Consumes(MediaType.APPLICATION_JSON)
	//jaxrs will looking to json data and will consturct staffmemebr object and inject to this method
	public StaffMember addStaffMember(StaffMember staffmember){
		userService.saveOrUpdate(staffmember);
		return staffmember;
	}
	
	
	
	
	
}
