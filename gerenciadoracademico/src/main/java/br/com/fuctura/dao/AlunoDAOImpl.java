package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fuctura.entidade.Aluno;

public class AlunoDAOImpl implements IAlunoDAO  {
	
	private Connection conexao;
	
	//construtor
	public AlunoDAOImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		conexao = conn;
	}
	
	//remover a palavra static
	public void inserir(Aluno aluno) throws SQLException {
		String sql = "INSERT INTO aluno VALUES (?, ?, ?)";

		PreparedStatement pstm = conexao.prepareStatement(sql);

		// (indice, valor)
		pstm.setString(1, aluno.getNome());
		pstm.setInt(2, aluno.getIdade());
		pstm.setString(3, aluno.getEmail());

		// executar
		pstm.execute();
	}

	public void excluir(Aluno aluno) throws SQLException {
		String sql = "DELETE FROM aluno WHERE nome LIKE ?";

		PreparedStatement pstm = conexao.prepareStatement(sql);

		// (indice, valor)
		pstm.setString(1, aluno.getNome());

		// executar
		pstm.execute();
	}

	public ArrayList<Aluno> consultar(Aluno aluno) throws SQLException {
		String sql = "SELECT * FROM aluno WHERE nome like ?";

		PreparedStatement pstm = conexao.prepareStatement(sql);

		// (indice, valor)
		pstm.setString(1, aluno.getNome());

		// executar
		ResultSet resultadoDaConsulta = pstm.executeQuery();

		ArrayList<Aluno> lista = new ArrayList<>();

		while (resultadoDaConsulta.next()) {
			String nome = resultadoDaConsulta.getString("nome");
			int idade = resultadoDaConsulta.getInt("idade");
			String email = resultadoDaConsulta.getString("email");

			Aluno a = new Aluno();
			a.setNome(nome);
			a.setIdade(idade);
			a.setEmail(email);

			lista.add(a);
		}
		
		resultadoDaConsulta.close();
		
		
		return lista;

	}

	@Override
	public void atualizar(Aluno aluno) throws SQLException {
		// TODO Auto-generated method stub
		
	}	
}
