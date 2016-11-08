package com.dim.cls.pay.dao.api;

import java.util.List;

import com.dim.cls.dao.abstracts.api.AbstractDao;
import com.dim.cls.model.LoginProfile;
import com.dim.cls.model.StaffMember;
import com.dim.cls.model.abstracts.AbstractPerson;  
  //test
import com.dim.cls.model.util.SysFlag;
  
public interface UserDao extends AbstractDao<StaffMember>  {  

	
	 public LoginProfile findByLoginProfile(LoginProfile loginProfile);

	
	//public void saveUser ( StaffMember staffMember );  

//public List<AbstractPerson> findAll();  
  
} 