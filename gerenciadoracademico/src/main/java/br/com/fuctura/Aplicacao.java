package br.com.fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import br.com.fuctura.entidade.Aluno;

public class Aplicacao {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		Properties props = new Properties();
		props.setProperty("user", "fuctura");
		props.setProperty("password", "123");

		Connection conexao = DriverManager.getConnection(url, props);

		System.out.println("Conectado com sucesso!");

		//Menu
		//1 - cadastrar Aluno
		
		//scanner 
		String nome = "";
		System.out.println("Digite seu nome: ");
		
		System.out.println("Digite sua idade: ");
		int idade = 0;
		
		System.out.println("Digite seu email: ");
		String email = "";
		
		//for, while ou do-while
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setIdade(idade);
		aluno.setEmail(email);
		
		inserirAluno(conexao, aluno);
		
		
		System.out.println("Inserido com sucesso!");
	}

	static void inserirAluno(Connection conexao, Aluno aluno) throws SQLException {
		String sql = "INSERT INTO aluno VALUES (?, ?, ?)";

		PreparedStatement pstm = conexao.prepareStatement(sql);

		// (indice, valor)
		pstm.setString(1, aluno.getNome());
		pstm.setInt(2, aluno.getIdade());
		pstm.setString(3, aluno.getEmail());

		// executar
		pstm.execute();
	}

}
