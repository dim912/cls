package com.dim.cls.util.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dim.cls.dao.abstracts.GenericHibernateDao;
import com.dim.cls.model.util.SysFlag;
import com.dim.cls.util.SysFlagDao;

@Repository
public class SysFlagDaoImpl extends GenericHibernateDao<SysFlag> implements SysFlagDao {
	
	@Override
	public List<Map<String, Object>> getSysFlags(SysFlag sysFlag) {
		
			
		return null;
	}

	@Override
	public void addSysFlags(List<Map<String, Object>> sysFlags) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFlags(List<Map<String, Object>> sysFlags) {
		// TODO Auto-generated method stub
		
	}
}
