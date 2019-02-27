package JavaExamples;

import java.util.ArrayList;
import java.util.List;

class WhileDemo {
    public static void main(String[] args) {
        int count = 1;
        while (count < 11) {
            System.out.println("Count is: " + count);
            count++;
        }
    }

}

class WhileDemoSelf {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        try {
            int i = 0;
            while (i <= 10) {
                i++;
                list.add(i);
//                    System.out.println(" " + list);
            }
            System.out.println("Final" + list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int y = list.get(4);
        System.out.println(y);

        Integer number;
        switch (y / 2) {
            case 0:
                number = y++;
                break;
            case 1:
                number = y--;
                break;
            default:
                number = 0;
                break;
        }
        System.out.println(number);

    }
}