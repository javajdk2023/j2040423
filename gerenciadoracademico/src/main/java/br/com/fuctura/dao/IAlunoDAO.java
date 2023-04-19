package br.com.fuctura.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fuctura.entidade.Aluno;

public interface IAlunoDAO {
	
	//assinatura
	void inserir(Aluno aluno) throws SQLException;
	void excluir(Aluno aluno) throws SQLException;
	ArrayList<Aluno> consultar(Aluno aluno) throws SQLException;
	void atualizar(Aluno aluno) throws SQLException;

}
