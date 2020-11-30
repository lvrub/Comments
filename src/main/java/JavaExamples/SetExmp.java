package JavaExamples;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetExmp {

    public static void main(String[] arg) {

        Set<String> collections = new LinkedHashSet<>();

        for (int i = 0; i > 5; i++) {
            collections.add("String" + i);
        }
        collections.add("One2");
        collections.add("One0");
        collections.add("One1");
        collections.add(null);

        System.out.println(collections);

        for (String s1 : collections) {
            System.out.println(s1);
        }
        Set<String> collections1 = new LinkedHashSet<>(4);
        collections1.add("One1");
        collections1.add("One2");

        System.out.println(collections.isEmpty());
        collections.removeAll(collections1);

        System.out.println(collections);
        System.out.println(collections.isEmpty());


    }
}
