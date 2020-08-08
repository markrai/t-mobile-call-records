package com.markrai.csvparser.utility;

import com.markrai.csvparser.Configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UtilityMethods {

	// parses a text file and returns the number of lines in it.
	public static int getNumberOfLines(String file) throws IOException {

		int numberOfLines = 0;
		BufferedReader reader = new BufferedReader(new FileReader(file));
		while (reader.readLine() != null)
			numberOfLines++;
		reader.close();
		return numberOfLines;
	}

	// converts date and time Strings into unified ISO8601 LocalDateTime object.
	public static LocalDateTime createDateTime(String date, String time) throws ParseException {
		String dateTimeString = date + " " + time;
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("MM/d/yyyy hh:mm a");
		return LocalDateTime.parse(dateTimeString, dateTimeFormat);

	}

	// adds 3 hours to message time-stamp to conform to Eastern Standard Time.
	public static LocalDateTime fixMessageTime(LocalDateTime dateTimeObj) {
		LocalDateTime fixedDateTime = null;
		fixedDateTime = dateTimeObj.plusHours(3);
		return fixedDateTime;
	}

	// converts call minute text to int
	public static int convertToMinutes(String mins) {
		int minutes = 0;

		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(mins);
		while (m.find()) {
			minutes = Integer.parseInt(m.group());
		}
		return minutes;

	}

	// fetches all files from directory
	public static List<File> getAllFiles() throws IOException {

		return Files.walk(Paths.get(Configuration.RECORDS_LOCATION)).filter(Files::isRegularFile).map(Path::toFile)
				.collect(Collectors.toList());
	}

}