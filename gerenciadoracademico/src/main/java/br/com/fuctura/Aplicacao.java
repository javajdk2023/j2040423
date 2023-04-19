package br.com.fuctura;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fuctura.config.Conexao;
import br.com.fuctura.dao.AlunoDAOImpl;
import br.com.fuctura.entidade.Aluno;

public class Aplicacao {

	public static void main(String[] args) throws SQLException {
		
		// Menu
		// 1 - cadastrar Aluno

		// scanner
		String nome = "Maria";
		System.out.println("Digite seu nome: ");

		System.out.println("Digite sua idade: ");
		int idade = 0;

		System.out.println("Digite seu email: ");
		String email = "B";

		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setIdade(idade);
		aluno.setEmail(email);

		// excluirAluno(conexao, aluno);

		System.out.println("Inserido com sucesso!");

		Conexao conexao = new Conexao();
		Connection connection = conexao.getMysql();
				
		AlunoDAOImpl dao = new AlunoDAOImpl(connection);
		ArrayList<Aluno> lista = dao.consultar(aluno);

		for (Aluno a : lista) {
			System.out.println("email: " + a.getEmail());
			System.out.println("idade: " + a.getIdade());
			System.out.println("nome " + a.getNome());
		}

	}

	
}
