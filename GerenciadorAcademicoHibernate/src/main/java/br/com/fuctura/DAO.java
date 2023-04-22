package br.com.fuctura;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO <E> {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> entidade;
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("FUCTURA-PU");
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public DAO(Class<E> entidade) {
		this.entidade = entidade;
		em = emf.createEntityManager();
	}
	
	
	public DAO<E> abrir() {
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> fechar() {
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> create(E entidade) {
		em.persist(entidade);
		return this;
	}
}
