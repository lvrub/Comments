package JavaExamples.LIsts;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        // Creating a list
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(0, 10); // adds 1 at 0 index
        l1.add(1, 20); // adds 2 at 1 index
        System.out.println(l1); // [10, 20]

        // Creating another list
        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(11);
        l2.add(21);
        l2.add(31);
        System.out.println(l2); // [1, 2, 3, 2]


        // Will add list l2 to l1 from 1 index
        l1.addAll(0, l2);
        System.out.println(l1);

        // Removes element from index 1
        l1.remove(1);
        System.out.println(l1); // [1, 2, 3, 2]

        // Prints element at index 3
        System.out.println(l1.get(3));

        // Replace 0th element with 5
        l1.set(0, 5);
        System.out.println(l1);

    }
}

