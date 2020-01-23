package JavaExamples;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Maps {

    public static void main(String[] arg) {

        HashMap<Integer, String> hmap = new HashMap<Integer, String>();

        hmap.put(12, "Chaitanya");
        hmap.put(2, "Rahul");
        hmap.put(7, "Singh");
        hmap.put(49, "Ajeet");
        hmap.put(3, "Anuj");

        hmap.put(7, "Changed");


        Set set = hmap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.print("key is: " + entry.getKey() + " & Value is: ");
            System.out.println(entry.getValue());
        }


    }
}
