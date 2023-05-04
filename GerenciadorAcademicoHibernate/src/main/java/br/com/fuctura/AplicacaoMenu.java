package br.com.fuctura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fuctura.menu.GerenciarCursoMenu;
import br.com.fuctura.menu.GerenciarDisciplinaMenu;

public class AplicacaoMenu {
	public static void main(String[] args) throws IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FUCTURA-PU");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		GerenciarCursoMenu cursoMenu = new GerenciarCursoMenu(emf);
		GerenciarDisciplinaMenu turmaMenu = new GerenciarDisciplinaMenu(emf);

		boolean continuar = true;

		while (continuar) {

			System.out.println("--- APLICAÇÃO MENU ---");
            System.out.println("1 - GERENCIAR CURSO");
            System.out.println("2 - GERENCIAR DISCIPLINA");
            System.out.println("3 - SAIR DA APLICAÇÃO");
            System.out.print("Digite a opção desejada: ");
			
			String opcaoDigitada = reader.readLine();

			int opcao = Integer.parseInt(opcaoDigitada);

			switch (opcao) {
			case 1:
				cursoMenu.exibirMenu();
				break;
			case 2:
				turmaMenu.exibirMenu();
				break;
			case 3:
				continuar = false;
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		}
		// emf.close();
	}
}
