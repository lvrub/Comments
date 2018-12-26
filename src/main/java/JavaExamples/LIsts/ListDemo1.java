package JavaExamples.LIsts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ListDemo1 {
    public static void main(String[] args) {
        // Type safe array list, stores only string
        List<String> l = new ArrayList<String>(5);
        l.add("Geeks");
        l.add("for");
        l.add("Geeks");

        // Using indexOf() and lastIndexOf()
        System.out.println("first index of Geeks:" +
                l.indexOf("Geeks"));
        System.out.println("last index of Geeks:" +
                l.lastIndexOf("Geeks"));
        System.out.println("Index of element" +
                " not present : " + l.indexOf("Hello"));
        l.add("Hello");

        for (String s : l) {
            System.out.println(s);
        }

        Iterator<String> iterator = l.iterator();
        while (iterator.hasNext()) {
            System.out.println("Via ITERATOR " + iterator.next());
        }

    }
}