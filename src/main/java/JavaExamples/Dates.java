package JavaExamples;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Dates {
    public static void main(String[] args) {

//        System.out.println(getDate(3));

        Date date = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM*dd*yyyy -hh:mm:ss");
        String formatedDate_1 = dateFormat.format(date);

        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_YEAR, -7);
        String formatedDate_2 = dateFormat.format(calendar.getTime());

        System.out.println(date);
        System.out.println(formatedDate_1);
        System.out.println(formatedDate_2);

        //            public static String getDate(int day){
//            Calendar calendar = new GregorianCalendar();
//            calendar.add(Calendar.DAY_OF_YEAR,day);
//        return dateFormat.format(calendar.getTime());
//        }
    }
}


