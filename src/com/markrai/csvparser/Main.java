package com.markrai.csvparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import com.markrai.csvparser.sqlite.DBWriter;
import com.markrai.csvparser.utility.UtilityMethods;

public class Main {

	static int counter = 0;

	public static void main(String[] args) throws Exception {

		PhoneRecordParser prd = new PhoneRecordParser();
		
		List<File> allFiles;
		allFiles = UtilityMethods.getAllFiles();

		for (File f : allFiles) {

			counter++;

			PhoneRecordParser.fileBeingProcessed = f.toString();

			BufferedReader objReader = new BufferedReader(new FileReader(PhoneRecordParser.fileBeingProcessed));

			
			System.out.println("Processing:" + f);
			prd.determineFileType(objReader);
			System.out.println("Completed: " + f);
			System.out.println();

		}

		System.out.println(counter + " CSV file(s) Processed!");

	}

}
