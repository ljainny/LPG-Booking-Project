package com.capgemini.lpg.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.capgemini.lpg.exception.LPGException;
/*
 * DBUtil class to access a connection pool 
 */
/**
 * 
 * @author Smita
 *
 */
public class DBUtil {
	static Connection connection;

	public static Connection obtainConnection() throws LPGException {
		try {
			InitialContext context = new InitialContext();
			DataSource source = (DataSource) context
					.lookup("java:/jdbc/MyDS");
			connection = source.getConnection();
		} catch (NamingException e) {
			throw new LPGException("Error while creating datascource::"
					+ e.getMessage());
		} catch (SQLException e) {
			throw new LPGException("Error while obtaining connection::"
					+ e.getMessage());
		}
		return connection;
	}
}
