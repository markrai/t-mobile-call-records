package com.markrai.csvparser.sqlite;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

	static String route = "C:\\dev\\db\\mysqlitedb.db";
	static java.sql.Connection c = null;
	
	public void connect() {
		try {
			c = DriverManager.getConnection("jdbc:sqlite:" + route);
			if (c != null)
				System.out.println("Connected to db.");
		} catch (SQLException ex) {
			System.err.println("Couldn't connect." + ex.getMessage());
		}
	}

}
