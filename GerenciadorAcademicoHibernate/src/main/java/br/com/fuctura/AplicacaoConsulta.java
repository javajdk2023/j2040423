package br.com.fuctura;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fuctura.dto.AlunoDTO;
import br.com.fuctura.entidade.Aluno;

public class AplicacaoConsulta {
	public static void main(String[] args) {

		// copiar e colar
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FUCTURA-PU");

		EntityManager em = emf.createEntityManager();

		//consultar alunos
		TypedQuery<Aluno> resultado = em.createQuery("select a from Aluno a", Aluno.class);
		
		List<Aluno> alunos = resultado.getResultList();
		
		for (Aluno aluno : alunos) {
			System.out.println("Nome: " + aluno.getNome());
		}
		
		//consultar com parâmetro - filtrar por nome 
		// resultado = em.createQuery("select a from Aluno a where nome like :name", Aluno.class);
		TypedQuery<Aluno> resultado2 = em.createQuery("select a from Aluno a where nome like :name and idade = :idade", Aluno.class);
		
		resultado2.setParameter("name", "maria");
		resultado2.setParameter("idade", 13);
		
		
		//Consultar nomeada
		TypedQuery<Aluno> resultado3 = em.createNamedQuery("Aluno.findByNomeAndIdade", Aluno.class);

		resultado3.setParameter("name", "maria");
		resultado3.setParameter("idade", 13);
		
		List<Aluno> alunos3 = resultado3.getResultList();
		
		for (Aluno aluno : alunos3) {
			System.out.println("Nome: " + aluno.getNome());
		}
		
		
		// projecao
		
		TypedQuery<AlunoDTO> resultado4 = em.createQuery("select new br.com.fuctura.dto.AlunoDTO(nome, idade) from Aluno a where nome like :name and idade = :idade", AlunoDTO.class);
		
		resultado4.setParameter("name", "maria");
		resultado4.setParameter("idade", 50);
		
		List<AlunoDTO> alunos4 = resultado4.getResultList();
		
		for (AlunoDTO aluno : alunos4) {
			System.out.println("Nome: " + aluno.getNome());
		}
		
		
		// emf.close();
	}
}
