package com.dim.cls.pay.dao.api;

import java.util.List;

import com.dim.cls.model.StaffMember;
import com.dim.cls.model.abstracts.AbstractPerson;  
  //test
  
public interface UserDao {  
public void saveUser ( StaffMember staffMember );  
public List<AbstractPerson> findAll();  
  
} 