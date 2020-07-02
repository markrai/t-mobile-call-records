package com.markrai.csvparser.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DBWriter {
	String statement = null;

	static String route = "C:\\dev\\db\\mysqlitedb.db";
	static java.sql.Connection c = null;

	public static Connection connect() {
		try {
			c = DriverManager.getConnection("jdbc:sqlite:" + route);
			// if (c != null)
			// System.out.println("Connected to db.");
		} catch (SQLException ex) {
			System.err.println("Couldn't connect." + ex.getMessage());
		}
		return c;
	}

	private Connection connection;

	public DBWriter(Connection connection) {
		this.connection = connection;
	}

	public DBWriter() {

	}

	private static final String INSERT_CALL = "INSERT INTO Records(datetime, destination, number, minutes, type) VALUES(?, ?, ?, ?, ?)";
	private static final String INSERT_MESSAGE = "INSERT INTO Records(datetime, destination, number, direction, type) VALUES(?, ?, ?, ?, ?)";

	public int insertCall(LocalDateTime dateTime, String destination, String number, int minutes, String type) {
		int numRowsInserted = 0;
		PreparedStatement psc = null;
		try {
			psc = this.connection.prepareStatement(INSERT_CALL);

			psc.setString(1, dateTime.toString());
			psc.setString(2, destination);
			psc.setString(3, number);
			psc.setInt(4, minutes);
			psc.setString(5, type);

			numRowsInserted = psc.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			close(psc);
		}

		return numRowsInserted;
	}

	public int insertMessage(LocalDateTime dateTime, String destination, String number, String direction, String type) {
		int numRowsInserted = 0;
		PreparedStatement psm = null;
		try {
			psm = this.connection.prepareStatement(INSERT_MESSAGE);

			psm.setString(1, dateTime.toString());
			psm.setString(2, destination);
			psm.setString(3, number);
			psm.setString(4, direction);
			psm.setString(5, type);

			numRowsInserted = psm.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			close(psm);
		}

		return numRowsInserted;
	}

	public static void close(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
