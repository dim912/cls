package com.dim.cls.pay.dao.impl.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import org.junit.Test;

import com.dim.cls.model.LoginProfile;
import com.dim.cls.model.StaffMember;

public class UserDaoImplTest {

	@Test
	public void test() {

		Map<String, Object> properties = new HashMap<>();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("RESTDemoJPA");

		// Test with simple query
		EntityManager em = factory.createEntityManager();

		/*
		em.getTransaction().begin();
		// create an Entity

		StaffMember m = new StaffMember();

		m.setFirstName("Dimtuhue");

		LoginProfile lp = new LoginProfile();
		lp.setUerName("dim912jdd2");
		lp.setPassword("asdf");
		m.setLoginProfile(lp);

		m.setSecondName("darshana");
		m.setSurName("senanayaka");

		 em.persist(m);
		 em.flush();
		em.getTransaction().commit();
		*/
		

		Query q = em.createQuery("select t from StaffMember t WHERE ID_INTERNAL = 9");

		List<StaffMember> l = q.getResultList();

		try {
			Thread.sleep(new Long("1000"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(l.get(0).getLoginProfile().getPassword());
		
		em.getTransaction().begin();

		
	   l.get(0).getLoginProfile().setPassword("newPwd");
	   
	   em.getTransaction().commit();
	}

}
