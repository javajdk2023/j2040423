package br.com.fuctura;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fuctura.entidade.Aluno;

public class Aplicacao {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FUCTURA-PU");
		
		EntityManager em = emf.createEntityManager();
		
		Aluno a = new Aluno();
		a.setNome("Maria");
		a.setEmail("maria@gmail.com");
		

		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		
		
		//emf.close();
	}

}
