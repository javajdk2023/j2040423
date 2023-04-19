package br.com.fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import br.com.fuctura.config.Conexao;
import br.com.fuctura.dao.AlunoDAOArquivoTexto;
import br.com.fuctura.dao.AlunoDAOImpl;
import br.com.fuctura.dao.IAlunoDAO;
import br.com.fuctura.entidade.Aluno;

public class AplicacaoComMenu {
	
	public static void main(String[] args) throws SQLException {
		Conexao conexao = new Conexao();
		Connection connection = conexao.getMysql(); 
		
		IAlunoDAO dao = new AlunoDAOImpl(connection);
		
		var aluno = new Aluno();
		
		try (Scanner scanner = new Scanner(System.in)) {
			int choice;

			do {
				
				System.out.println("Escolha uma opção:");
				System.out.println("1 - Cadastrar Aluno");
				System.out.println("2 - Listar todos os alunos");
				System.out.println("3 - Sair");
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
					
					aluno.setNome(nome);
					aluno.setEmail(email);
					aluno.setIdade(idade);

					dao.inserir(aluno);

					System.out.println("Aluno inserido com sucesso!");

					break;
				case 2:
					System.out.println("Você escolheu a opção 2.");
					System.out.println("Digite o nome do aluno: ");
					
					nome = scanner.next();
					aluno = new Aluno();
					aluno.setNome(nome);
					
					ArrayList<Aluno> lista = dao.consultar(aluno);

					for (Aluno a : lista) {
						System.out.println("email: " + a.getEmail());
						System.out.println("idade: " + a.getIdade());
						System.out.println("nome " + a.getNome());
					}
					
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
}
