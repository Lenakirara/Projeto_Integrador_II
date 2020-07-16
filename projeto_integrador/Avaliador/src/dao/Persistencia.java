package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
// Seleciona aonde vai pegar o banco de dados
public class Persistencia {
	static Connection conn = null;
	public static java.sql.Connection getConnection() {

		// SQLite connection string
		String url = "jdbc:sqlite://C://projeto_integrador//dados//Banco_Avaliador.db";
		
		try {
			conn = DriverManager.getConnection(url);
			conn.setAutoCommit(true);
			
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
}
