package com.markrai.csvparser;

import java.io.IOException;
import java.sql.SQLException;

import com.markrai.csvparser.utility.UtilityMethods;

public class Test {

	public static void main(String[] args) throws SQLException, IOException {

		UtilityMethods.fetchAllFiles();
	}
}
