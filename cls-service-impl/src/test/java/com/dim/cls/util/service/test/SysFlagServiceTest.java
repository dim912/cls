package com.dim.cls.util.service.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.dim.cls.model.util.SysFlag;
import com.dim.cls.service.util.api.SysFlagServiceApi;
import com.dim.cls.util.service.SysFlagService;

public class SysFlagServiceTest {
	
	SysFlagServiceApi sysFlagServiceApi;
	@Before
	public void before(){
		//create mock object
		sysFlagServiceApi = new SysFlagService();
	}

	@Test
	public void testSaveFlag() {
		
		SysFlag sysFlag = new SysFlag();
		//sysFlag.setDtCreated(new Date());
		//sysFlag.setDtLastUpdated(new Date());
		sysFlag.setIdCreatedBy(new Long("10000"));
		sysFlag.setStatus("A");
		sysFlag.setFlagName("Test Flag");
		sysFlagServiceApi.saveFlag(sysFlag);
		//fail("Not yet implemented");
	}

}
