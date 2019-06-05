package JavaExamples.FileNavigation;

import com.opencsv.CSVWriter;

import java.io.*;

public class CSVFiles {
    private static String line;

    public CSVFiles(String path) {
    }

    public static void main(String[] arg) throws IOException {

        String path = "E:/csvfile.csv";

        File file = new File(path);
        if (file.exists()) {
            System.out.println("File exists");
        } else {
            file.createNewFile();
            System.out.println("File created");
        }
        FileWriter fileWriter = new FileWriter(path);
        CSVWriter writer = new CSVWriter(fileWriter);

        // adding header to csv
        String[] header = {"Name, Class, Marks"};
        writer.writeNext(header);

        // add data to csv
        String[] data1 = {"Aman, 10, 620"};
        writer.writeNext(data1);
        String[] data2 = {"Suraj", "10", "630"};
        writer.writeNext(data2);
        // closing writer connection
        writer.close();

        FileReader fileReader = new FileReader(path);
        BufferedReader br = new BufferedReader(fileReader);

        while ((line = br.readLine()) != null) {
            // use comma as separator
            String[] country = line.split(",");
            System.out.println(country[0] + country[1] + country[2]);
        }

    }
}