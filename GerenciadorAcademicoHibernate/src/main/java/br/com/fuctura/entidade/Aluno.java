package br.com.fuctura.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name= "Aluno.findAll", query = "select a from Aluno a"),
	@NamedQuery(name= "Aluno.findByNome", query = "select a from Aluno a where nome like :name"),
	@NamedQuery(name= "Aluno.findByNomeAndIdade", query = "select a from Aluno a where nome like :name and idade = :idade"),
})

@Table(name = "TB_ALUNO")
public class Aluno {
	private String nome;
	private int idade;
	
	@Id
	private String email;
	
	@Column(name = "media", nullable = false)
	private double media;
	
	private double altura;
	
	//getters e setters
	
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getMedia() {
		return media;
	}
	public void setMedia(double media) {
		this.media = media;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	
}
