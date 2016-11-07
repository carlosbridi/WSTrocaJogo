package com.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {

	private static Connection connection = null;

	public static Connection conectar() {

		if (connection == null){
			try {
	
				Class.forName("org.postgresql.Driver");
		
				connection = DriverManager.getConnection(
						"jdbc:postgresql://127.0.0.1:5432/TrocaJogo", "postgres",
						"11novembro92");
				
				return connection;
			}catch (ClassNotFoundException e){
				System.out.println("Falha no registro do driver");
				e.printStackTrace();
				
			} catch (SQLException e) {
	
				System.out.println("Conexão falhou!");
				e.printStackTrace();
	
			}
		}
		
		return connection;
		
	}
}
