package it.prova.manytomanybranogeneremaven.dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface IBaseDAO<T> {

	public List<T> findAll() throws Exception;

	public T findById(Long id) throws Exception;

	public void update(T o) throws Exception;

	public void insert(T o) throws Exception;

	public void delete(Long id) throws Exception;

	// questo mi serve per l'injection
	public void setEntityManager(EntityManager entityManager);

}
