package br.com.fuctura.menu;

import javax.persistence.EntityManagerFactory;

public class GerenciarDisciplinaMenu {
	private EntityManagerFactory factory;
	
	public GerenciarDisciplinaMenu(EntityManagerFactory factory) {
		this.factory = factory;
	}
	
	public void exibirMenu() {
		//utilizar o curso como exemplo
	}

	public String getDescricao() {
		return "Gerenciar Turma";
	}

}
