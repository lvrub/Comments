package JavaExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
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
        list.add(15);
        list.add(1);
        list.add(2);
        list.add(100);
        list.add(50);

        Optional<Integer> maxValue = list.stream().max(Integer::compareTo);
        System.out.println("MaxValue=" + maxValue);
        Optional<Integer> minValue = list.stream().min(Integer::compareTo);
        System.out.println("MinValue=" + minValue);

        Stream<Integer> stream = list.stream();
        stream.forEach(x -> System.out.println(x));


        list.stream()
                .filter(y -> y % 2 == 0)
                .forEach(System.out::println);

        Stream<String> str = strings.stream();
        str.filter(st -> Character.isUpperCase(st.charAt(1)))
                .forEach(System.out::println);

//        ()->str.sorted(System.out::println);

//        int[] numbers = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
//        int count=0;
//        for(int i:numbers){ if(i > 0) count++;
//        }
//        System.out.println(count);
//
        long count = IntStream.of(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 3).filter(w -> w > 0).count();
        System.out.println(count);
        LongStream.of(-5, -4, -3, -2, -1, 0, 5, 1, 3, 2, 4).filter(w -> w > 0).limit(3).sorted().forEach(System.out::println);


        LongStream.of(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5).filter(w -> w > 0).findAny();


    }
}

