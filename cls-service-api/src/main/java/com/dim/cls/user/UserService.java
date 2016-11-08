package com.dim.cls.user;

import java.util.List;

import com.dim.cls.model.LoginProfile;
import com.dim.cls.model.StaffMember;
import com.dim.cls.model.abstracts.AbstractPerson;

public interface UserService  {
	
	 public void saveOrUpdate(StaffMember staffMember);  
	 public List<StaffMember> findAll();
	 public StaffMember findById(long id);
	 
	 public StaffMember logIn(LoginProfile loginProfile);
	 public boolean logOut(LoginProfile loginProfile);
	 
	 
}
