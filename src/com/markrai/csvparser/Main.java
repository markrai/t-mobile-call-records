package com.markrai.csvparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

import com.markrai.csvparser.utility.UtilityMethods;

public class Main {

    static int counter = 0;

    public static void main(String[] args) throws Exception {

        /* optional: command line menu selector
        Scanner input = new Scanner(System.in);
        String choice;
        Configuration config = new Configuration();
        System.out.println("Enter 1 for `His` or 2 for `Her`...");
        choice = input.nextLine();
        if (choice == "1") {
            config.DB_LOCATION = "C:\\dev\\db\\his.db";
            config.RECORDS_LOCATION = "C:\\TEMP\\phonerecords\\his\\";
        }

        if (choice == "2") {
            config.DB_LOCATION = "C:\\dev\\db\\her.db";
            config.RECORDS_LOCATION = "C:\\TEMP\\phonerecords\\her\\";
        }
*/


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
