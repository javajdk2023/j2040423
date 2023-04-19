package br.com.fuctura.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {

	public Connection get() throws SQLException {

		String url = "jdbc:postgresql://localhost:5432/fuctura";
		Properties props = new Properties();
		props.setProperty("user", "fuctura");
		props.setProperty("password", "123");

		Connection conexao = DriverManager.getConnection(url, props);

		System.out.println("Conectado com sucesso!");

		return conexao;
	}

	public Connection getMysql() throws SQLException {

		String url = "jdbc:postgresql://localhost:5432/fuctura";
		Properties props = new Properties();
		props.setProperty("user", "fuctura");
		props.setProperty("password", "123");

		Connection conexao = DriverManager.getConnection(url, props);

		System.out.println("Conectado com sucesso!");

		return conexao;
	}

}
