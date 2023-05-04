package br.com.fuctura.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Disciplina {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;

	private String nome;
	private int cargaHoraria;
	private int numSala;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public int getNumSala() {
		return numSala;
	}

	public void setNumSala(int numSala) {
		this.numSala = numSala;
	}
}
