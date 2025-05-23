package it.prova.manytomanybranogeneremaven.dao.genere;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.manytomanybranogeneremaven.model.Genere;

public class GenereDAOImpl implements GenereDAO {

	private EntityManager entityManager;

	@Override
	public List<Genere> findAll() throws Exception {
		return entityManager.createQuery("from Genere", Genere.class).getResultList();
	}

	@Override
	public Genere findById(Long id) throws Exception {
		return entityManager.find(Genere.class, id);
	}

	@Override
	public void update(Genere input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Genere input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.createQuery("delete from Genere where id=?1").setParameter(1, id).executeUpdate();
	}
	
	@Override
	public Genere findByDescrizione(String descrizioneInput) throws Exception {
		TypedQuery<Genere> query = entityManager
				.createQuery("select g from Genere g where g.descrizione=?1", Genere.class)
				.setParameter(1, descrizioneInput);
		
		return query.getResultStream().findFirst().orElse(null);
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
