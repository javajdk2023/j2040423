package br.com.fuctura.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fuctura.entidade.Curso;

public class CursoDAO {
	EntityManager em;
	
	public CursoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salvar(Curso curso) {
		em.getTransaction().begin();
		em.persist(curso);
		em.getTransaction().commit();
	}
	
	public List<Curso> buscarTodos() {
		TypedQuery<Curso> query = em.createQuery("select c from Curso c", Curso.class);
		return query.getResultList();
	}
	
	public void close() {
		em.close();
	}

	public Curso pesquisarPorId(Long id) {
		return em.find(Curso.class, id);
	}

	public void atualizar(Curso curso) {
		em.getTransaction().begin();
		em.merge(curso);
		em.getTransaction().commit();
	}

	public void excluir(Curso curso) {
		em.getTransaction().begin();
		em.remove(curso);
		em.getTransaction().commit();
	}
	
}
