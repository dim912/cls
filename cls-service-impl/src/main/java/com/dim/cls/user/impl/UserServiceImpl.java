package com.dim.cls.user.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dim.cls.model.StaffMember;
import com.dim.cls.model.abstracts.AbstractPerson;
import com.dim.cls.pay.dao.api.UserDao;
import com.dim.cls.user.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao ;

	@Transactional(propagation = Propagation.REQUIRED) //this is the default trasaction attribute. 

	public List<AbstractPerson> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRED) //this is the default trasaction attribute. 
	//If there is no transaction is assosiated, then a new trasaction should be started at this point.
	//If there is already a started transaction it should be used.
	public void saveOrUpdate(StaffMember staffMember) {
		System.out.println("3");

		userDao.saveUser(staffMember);
	}

	@PostConstruct
	public void init(){
		System.out.println("UserService Bean is loaded");
	}
}
