package br.com.fuctura.entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Curso {
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "meu-gerador")
	@SequenceGenerator(name = "meu-gerador", initialValue = 2,  sequenceName = "curso_id_seq")
	@Id
	private Long id;

	private String nome;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "curso_id", referencedColumnName = "id")
	private List<Disciplina> disciplinas;
		
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

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
}
