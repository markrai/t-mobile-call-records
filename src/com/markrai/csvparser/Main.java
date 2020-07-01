package com.markrai.csvparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import com.markrai.csvparser.utility.UtilityMethods;

public class Main {

	public static void main(String[] args) throws Exception {

		List<File> allFiles;
		allFiles = UtilityMethods.getAllFiles();

		for (File f : allFiles) {

			PhoneRecordParser.fileBeingProcessed = f.toString();

			BufferedReader objReader = new BufferedReader(new FileReader(PhoneRecordParser.fileBeingProcessed));

			PhoneRecordParser prd = new PhoneRecordParser();
			prd.determineFileType(objReader);

		}

		System.out.println("All Files Processed!");

	}

}
