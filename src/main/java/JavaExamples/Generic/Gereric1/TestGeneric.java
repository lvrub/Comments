package JavaExamples.Generic.Gereric1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestGeneric {
    public static void main(String[] arg) {
        List list = new LinkedList<>();
        list.add("First");
        list.add("Second");
        List<String> list2 = list;
        for (Iterator<String> itemItr = list2.iterator(); itemItr.hasNext(); )
            System.out.println(itemItr.next());

        List<String> list1 = new LinkedList<String>();
        list1.add("First1");
        list1.add("Second1");
        List list3 = list1;
        for (Iterator<String> itemItr = list3.iterator(); itemItr.hasNext(); )
            System.out.println(itemItr.next());

    }
}

class Utilities {
    public static <T> void fill(List<T> list, T val) {
        for (int i = 0; i < list.size(); i++)
            list.set(i, val);
    }
}

class Test {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(2);
        System.out.println("Список до обработки дженерик-методом: " + intList);
        Utilities.fill(intList, 0);
        System.out.println("Список после обработки дженерик-методом: "
                + intList);
    }
}

class Pair<T1, T2> {
    T1 object1;
    T2 object2;

    Pair(T1 one, T2 two) {
        object1 = one;
        object2 = two;
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<Integer, String>(6, " Apr");
        System.out.println(pair.getFirst() + pair.getSecond());
    }

    public T1 getFirst() {
        return object1;
    }

    public T2 getSecond() {
        return object2;
    }
}

class PairOfT<T> {
    T object1;
    T object2;

    PairOfT(T one, T two) {
        object1 = one;
        object2 = two;
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<Integer, String>(1, " Apr");
        System.out.print(pair.getFirst() + pair.getSecond());
    }

    public T getFirst() {
        return object1;
    }

    public T getSecond() {
        return object2;
    }
}

class Test2 {
    static void printList(List<?> list) {
        for (Object l : list)
            System.out.println(l);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(100);
        printList(list);

        List<String> strList = new ArrayList<>();
        strList.add("101");
        strList.add("1001");
        printList(strList);
    }
}

class Numbers {

    static void printList(List<? extends Number> list) {
        for (Object l : list)
            System.out.println(l);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(100);
        printList(list);

        List<Double> strList = new ArrayList<>();
        strList.add(10.9);
        strList.add(34.09);
        printList(strList);
    }
}


