package JavaExamples;

import java.util.*;

public class MapsComparing {


    public static void main(String[] arg) {

        Map map_1 = new LinkedHashMap();
        map_1.put("ivan", "10");
        map_1.put("bob", "9");
        map_1.put("stela", "6");
        map_1.put("kola", "3");

        Map map_2 = new LinkedHashMap();
        map_2.put("ivan", "8");
        map_2.put("bob", "4");
        map_2.put("stela", "7");
        map_2.put("kola", "3");

        ArrayList list_1 = new ArrayList(map_1.values());
        ArrayList list_2 = new ArrayList(map_2.values());

        System.out.println(list_1);
        System.out.println(list_2);

        ArrayList listMax = null;


        for (int i = 0; i < list_1.size(); i++) {
            int maxim = Math.max(Integer.parseInt((String) list_1.get(i)), Integer.parseInt((String) list_2.get(i)));

            listMax = new ArrayList();
            listMax.add(maxim);
            System.out.println(listMax);
        }

        Map maxGrade = map_1;
        List<String> list = Arrays.asList(map_1.keySet().toString().split(","));
        List<String> updList = new LinkedList<>();

        for (String st : list) {
            updList.add(st);
        }


        System.out.println(list);
        System.out.println(updList);


        maxGrade.put(list, listMax);
        System.out.println(maxGrade);


    }
}
