package com.dim.cls.util.impl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.dim.cls.model.util.SysFlag;
import com.dim.cls.util.SysFlagDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-context-test.xml"})
@TransactionConfiguration(transactionManager="transactionManager")
public class SysFlagDaoImplTest {
	
	@Autowired
	SysFlagDao sysFlagDao;
	

	@Test
	public void testGetSysFlags() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddSysFlags() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateFlags() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	@Transactional
	@Rollback(false)
	public void testCreate() {
		SysFlag sysFlag = new SysFlag();
		//sysFlag.setDtCreated(new Date());
		System.out.println("created");
		sysFlagDao.create(sysFlag);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

}
