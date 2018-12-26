package JavaExamples.LIsts;

import java.util.ArrayList;
import java.util.List;


public class ListDemo2 {

    public static void main(String[] args) {
        // Type safe array list, stores only string
        List<String> l = new ArrayList<String>(5);

        l.add("GeeksforGeeks");
        l.add("Practice");
        l.add("GeeksQuiz");
        l.add("IDE");
        l.add("Courses");

        List<String> range = new ArrayList<String>();

        // Return List between 2nd(including)
        // and 4th element(excluding)
        range = l.subList(2, 4);

        System.out.println(range);

        System.out.println(" TEST " + l);

        l.remove(2);
        for (String s : l) {
            System.out.println(s);
        }
        System.out.println("---------------------");

        l.remove("IDE");
        for (String s : l) {
            System.out.println(s);
        }
        System.out.println("**********************");
        System.out.println(l.contains("Practice"));

        l.clear();
        l.add(1, "yyyy");
        try {
            for (String s : l) {
                System.out.println(s + "  Empty");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
        }
    }
}