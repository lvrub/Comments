package JavaExamples;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestWriteFile {
    public static void main(String[] args) {
        BufferedWriter writer = null;
        try {
            //create a temporary file
            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            File logFile = new File(timeLog);

            // This will output the full path where the file will be written to...
            System.out.println(logFile.getAbsolutePath());

            try (FileOutputStream fos = new FileOutputStream(timeLog)) {
                String text = new SimpleDateFormat().getTimeZone().getDisplayName().toString();
                // перевод строки в байты
//                byte[] buffer = text.getBytes();

                fos.write(text.getBytes());
            } catch (IOException ex) {

                System.out.println(ex.getMessage());
            }
            System.out.println("The file has been written");

//            writer = new BufferedWriter(new FileWriter(logFile));
//            writer.write("Hello world!");
            boolean a = logFile.exists();
            System.out.println(a);

            String b = logFile.getAbsolutePath().toString();
//            System.out.println(b);

            try (FileInputStream fin = new FileInputStream(b)) {
                System.out.printf("File size: %d bytes \n", fin.available());
                System.out.println("C:\\Automation\\" + b);

                int i = -1;
                while ((i = fin.read()) != -1) {
                    System.out.print((char) i);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
    }
}

class ReadFiles {


}
