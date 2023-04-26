package br.com.fuctura;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.github.javafaker.Faker;

import br.com.fuctura.entidade.Aluno;

public class Aplicacao2 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FUCTURA-PU");
		
		EntityManager em = emf.createEntityManager();
		
		Faker faker = new Faker();
		
		for (int i = 0; i < 10; i++) {
			Aluno a = new Aluno();
			a.setNome(faker.name().firstName());
			a.setEmail(faker.internet().emailAddress());
			
			em.getTransaction().begin();
			em.persist(a);
			em.getTransaction().commit();
		}
		
		/*
		Aluno a = new Aluno();
		a.setNome("Maria");
		a.setEmail("maria@gmail.com");
		
		Aluno b = new Aluno();
		b.setNome("Joao");
		b.setEmail("joao@gmail.com");
		
		em.getTransaction().begin();
		a.setNome("joao");
		em.persist(a);
		em.persist(b);
		em.persist(a);
		em.getTransaction().commit();
		em.close();
		*/
		
		//emf.close();
	}

}
