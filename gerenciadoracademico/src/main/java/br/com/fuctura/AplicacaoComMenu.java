package br.com.fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import br.com.fuctura.entidade.Aluno;

public class AplicacaoComMenu {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/fuctura";
		Properties props = new Properties();
		props.setProperty("user", "fuctura");
		props.setProperty("password", "123");

		Connection conexao = DriverManager.getConnection(url, props);
		
		
		
		
		try (Scanner scanner = new Scanner(System.in)) {
			int choice;

			do {
				System.out.println("Escolha uma opção:");
				System.out.println("1 - Cadastrar Aluno");
				System.out.println("2 - Listar todos os alunos");
				System.out.println("3 - Excluir aluno por nome");
				System.out.println("4 - Atualizar aluno");
				System.out.println("Digite: ");

				choice = scanner.nextInt();

				switch (choice) {
				case 1:
					
					System.out.println("Digite o nome do aluno: ");
					var nome = scanner.next();
					System.out.println("Digite o email do aluno: ");
					var email = scanner.next();	
					System.out.println("Digite o email do aluno: ");
					var idade = scanner.nextInt();
					
					var aluno = new Aluno();
					aluno.setNome(nome);
					aluno.setEmail(email);
					aluno.setIdade(idade);

					inserirAluno(conexao, aluno);
					
					System.out.println("Aluno inserido com sucesso!");
					
					break;
				case 2:
					System.out.println("Você escolheu a opção 2.");
					break;
				case 3:
					System.out.println("Fim!");
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
					break;
				}
			} while (choice != 3);
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

}
