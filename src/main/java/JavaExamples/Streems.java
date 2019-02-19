package JavaExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Streems {
    public static void main(String[] args) {
        List<String> strings = new ArrayList();
//        List<String> strings1 = Arrays.asList("Java is the best", "Java 8", "Java 9", "Jacoco", "BLOB");
        strings.add("BLOB1");
        strings.add("Java is the best");
        strings.add("Java 8");
        strings.add("Java 9");
        strings.add("Jacoco");

//        Example_1
        Optional<String> java = strings.stream().findAny();
        System.out.println(java); //output Optional[BLOB]

        // Example_2
        Optional<String> java1 = strings.stream().filter(s -> s.contains("Java")).findAny();
        System.out.println(java1);

//        Example_3
        ArrayList<Integer> list = new ArrayList();
        list.add(0, 15);
        list.add(1, 1);
        list.add(2, 2);
        list.add(3, 100);
        list.add(4, 50);

        Optional<Integer> maxValue = list.stream().max(Integer::compareTo);
        System.out.println("MaxValue=" + maxValue);
        Optional<Integer> minValue = list.stream().min(Integer::compareTo);
        System.out.println("MinValue=" + minValue);

        Stream<Integer> stream = list.stream();
        stream.forEach(x -> System.out.println(x));

//        list.stream().filter(y-> {
//            System.out.println("new" + y);
//            return(y);
    }
}
