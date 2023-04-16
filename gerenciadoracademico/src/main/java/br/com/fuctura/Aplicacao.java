package br.com.fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import br.com.fuctura.entidade.Aluno;

public class Aplicacao {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/fuctura";
		Properties props = new Properties();
		props.setProperty("user", "fuctura");
		props.setProperty("password", "123");

		Connection conexao = DriverManager.getConnection(url, props);

		System.out.println("Conectado com sucesso!");

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

		ArrayList<Aluno> lista = consultarAluno(conexao, aluno);

		for (Aluno a : lista) {
			System.out.println("email: " + a.getEmail());
			System.out.println("idade: " + a.getIdade());
			System.out.println("nome " + a.getNome());
		}

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

	static void excluirAluno(Connection conexao, Aluno aluno) throws SQLException {
		String sql = "DELETE FROM aluno WHERE nome LIKE ?";

		PreparedStatement pstm = conexao.prepareStatement(sql);

		// (indice, valor)
		pstm.setString(1, aluno.getNome());

		// executar
		pstm.execute();
	}

	static ArrayList<Aluno> consultarAluno(Connection conexao, Aluno aluno) throws SQLException {
		String sql = "SELECT * FROM aluno WHERE nome like ?";

		PreparedStatement pstm = conexao.prepareStatement(sql);

		// (indice, valor)
		pstm.setString(1, aluno.getNome());

		// executar
		ResultSet resultadoDaConsulta = pstm.executeQuery();

		ArrayList<Aluno> lista = new ArrayList<>();

		while (resultadoDaConsulta.next()) {
			String nome = resultadoDaConsulta.getString("nome");
			int idade = resultadoDaConsulta.getInt("idade");
			String email = resultadoDaConsulta.getString("email");

			Aluno a = new Aluno();
			a.setNome(nome);
			a.setIdade(idade);
			a.setEmail(email);

			lista.add(a);
		}

		return lista;

	}
}
