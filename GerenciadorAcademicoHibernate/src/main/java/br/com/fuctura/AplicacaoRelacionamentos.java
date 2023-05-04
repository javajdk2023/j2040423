package br.com.fuctura;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fuctura.entidade.Aluno;
import br.com.fuctura.entidade.Disciplina;
import br.com.fuctura.entidade.Endereco;

public class AplicacaoRelacionamentos {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FUCTURA-PU");

		EntityManager em = emf.createEntityManager();

		Endereco endereco = new Endereco();
		endereco.setCep("50741258");
		endereco.setBairro("Recife");

		Endereco endereco2 = new Endereco();
		endereco2.setCep("741852");
		endereco2.setBairro("Camaragibe");

		Endereco endereco3 = new Endereco();
		endereco3.setCep("741854");
		endereco3.setBairro("Prazeres");

//		System.out.println("ID: " + endereco.getCodigo());
		// salvar endereco
//		em.getTransaction().begin();
//		em.persist(endereco);
//		em.persist(endereco2);
//		em.persist(endereco3);
//		em.getTransaction().commit();
//		System.out.println("ID: " + endereco.getCodigo());
//		System.out.println("ID: " + endereco2.getCodigo());
//		System.out.println("ID: " + endereco3.getCodigo());

		Aluno aluno = new Aluno();
		aluno.setNome("Joao");
		aluno.setEmail("joao@gmail.com");
		aluno.setEndereco(endereco);

		Disciplina d1 = new Disciplina();
		d1.setNome("Matemática");
		d1.setCargaHoraria(60);
		d1.setNumSala(1190);

		Disciplina d2 = new Disciplina();
		d2.setNome("Estrutura de Dados");
		d2.setCargaHoraria(90);
		d2.setNumSala(1191);

		List<Disciplina> disciplinas = new ArrayList<>();
		disciplinas.add(d1);
		disciplinas.add(d2);

		aluno.setDisciplinas(disciplinas);

		// salvar
		// salvar aluno
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();

		em.detach(aluno);
		
		//consultar o aluno 
		TypedQuery<Aluno> consulta = em.createQuery("select a from Aluno a", Aluno.class);
		
		List<Aluno> listaAluno = consulta.getResultList();
		
		for (Aluno aluno2 : listaAluno) {
			System.out.println("Nome do Aluno:  " + aluno2.getNome());
			System.out.println("Endereço do aluno: " + aluno2.getEndereco().getBairro());
		}
	}

}
