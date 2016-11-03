package com.dim.cls.dao.abstracts;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dim.cls.dao.abstracts.api.AbstractDao;

public abstract class GenericHibernateDao<T> implements AbstractDao<T>{

	private Class<T> clazz;

	@PersistenceContext(name="myEmf")
	EntityManager entityManagery;
	//SessionFactory sessionFactory;

	public final void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	public T findOne(long id) {
System.out.println("tt");
		return entityManagery.find(clazz, id);
		//return (T) getCurrentSession().get(clazz, id);
		//return null;
	}

	public List<T> findAll() {
		
		System.out.println("called333");
		
		System.out.println(entityManagery);
		
		Query query = entityManagery.createQuery("SELECT T FROM " + clazz.getName()+ " T");
		List<T> resultList = query.getResultList();
		return resultList;
	}

	public void create(T entity) {
		//getCurrentSession().persist(entity);
		System.out.println("called2");
		entityManagery.persist(entity);
		System.out.println("called34");

	}

	public void update(T entity) {
		entityManagery.merge(entity);
		//getCurrentSession().merge(entity);
	}

	public void delete(T entity) {
		entityManagery.remove(entity);
		//getCurrentSession().delete(entity);
		//getCurrentSession().delete(entity);		
	}

	public void deleteById(long entityId) {
		T entity = findOne(entityId);
		delete(entity);
	}

	//protected final Session getCurrentSession() {
	protected final Session getCurrentSession() {
		//return sessionFactory.getCurrentSession();
		//return sessionFactory.
		return null;
	}
}