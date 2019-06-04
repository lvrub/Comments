package JavaExamples;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

class CSV_Reader {
    private static final String SAMPLE_CSV_FILE_PATH = "c:/ect-apr2019-csv-tables.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index

                String string_1 = csvRecord.get(0);
                String string_2 = csvRecord.get(1);
                String string_3 = csvRecord.get(2);
                String string_4 = csvRecord.get(3);
                String string_5 = csvRecord.get(4);
                String string_6 = csvRecord.get(5);
                String string_7 = csvRecord.get(6);
                String string_8 = csvRecord.get(7);
                String string_9 = csvRecord.get(8);
                String string_10 = csvRecord.get(9);


                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("String 1 : " + string_1);
                System.out.println("String 2 : " + string_2);
                System.out.println("String 3 : " + string_3);
                System.out.println("String 4 : " + string_4);
                System.out.println("String 5 : " + string_5);
                System.out.println("String 6 : " + string_6);
                System.out.println("String 7 : " + string_7);
                System.out.println("String 8 : " + string_8);
                System.out.println("String 9 : " + string_9);
                System.out.println("String 10 : " + string_10);


                System.out.println("---------------\n\n");
            }
        }
    }
}