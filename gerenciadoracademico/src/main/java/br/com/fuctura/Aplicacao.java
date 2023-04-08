package br.com.fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Aplicacao {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/fuctura";
		Properties props = new Properties();
		props.setProperty("user", "fuctura");
		props.setProperty("password", "123");
		
		Connection conn = DriverManager.getConnection(url, props);
		
		System.out.println("Conectado com sucesso!");

	}
}
