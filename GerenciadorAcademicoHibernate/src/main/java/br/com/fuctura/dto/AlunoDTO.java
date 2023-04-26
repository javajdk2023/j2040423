package br.com.fuctura.dto;

public class AlunoDTO {

	private String nome;
	private int idade;
	private double media;

	public AlunoDTO(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public AlunoDTO(String nome, int idade, double media) {
		this.nome = nome;
		this.idade = idade;
		this.media = media;
	}
	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	// construtor

	// getters and setter

}
