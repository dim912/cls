package com.dim.cls.dao.abstracts.api;

import java.util.List;

public interface AbstractDao<T> {
	
	public T findOne(long id) ;

	public List<T> findAll() ;

	public void create(T entity);

	public void update(T entity) ;

	public void delete(T entity) ;

	public void deleteById(long entityId) ;
}
