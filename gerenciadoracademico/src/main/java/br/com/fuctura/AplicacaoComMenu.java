package br.com.fuctura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.fuctura.config.Conexao;
import br.com.fuctura.dao.AlunoDAOImpl;
import br.com.fuctura.dao.IAlunoDAO;
import br.com.fuctura.entidade.Aluno;
import br.com.fuctura.entidade.Professor;

public class AplicacaoComMenu {
	
	public static void main(String[] args) throws SQLException {
		Conexao conexao = new Conexao();
		Connection connection = conexao.getMysql(); 
		
		IAlunoDAO dao = new AlunoDAOImpl(connection);
		
		var aluno = new Aluno();
		
		
		
		

	}

	
}
