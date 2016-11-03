package com.dim.cls.util.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dim.cls.model.util.SysFlag;
import com.dim.cls.service.util.api.SysFlagServiceApi;
import com.dim.cls.util.SysFlagDao;

@Service
public class SysFlagService implements SysFlagServiceApi  {
	
	@Autowired
	private SysFlagDao sysFlagDao ; 

	
	public void saveFlag(SysFlag sysFlag){
		sysFlagDao.create(sysFlag);
	}


	public SysFlagDao getSysFlagDao() {
		return sysFlagDao;
	}


	public void setSysFlagDao(SysFlagDao sysFlagDao) {
		this.sysFlagDao = sysFlagDao;
	}
	

}
