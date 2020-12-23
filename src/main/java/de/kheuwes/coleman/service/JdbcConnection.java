package de.kheuwes.coleman.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {
	Connection connection = null;
	public JdbcConnection(String url) {
		try {
			connection = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
	public ResultSet getResultset(String sql) {
		Statement statement;
		ResultSet result = null;
		try {
			statement = connection.createStatement();
			result = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        return result;
	}

}
