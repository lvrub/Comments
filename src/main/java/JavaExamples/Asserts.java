package JavaExamples;

import java.util.Scanner;

public class Asserts {
    public static void main(String args[]) {
        int value = 25;
//        assert (value <= 20) : " Underweight";
//        System.out.println("value is " + value);

        assert (value == 11) : false;
        System.out.println("value is correct ");
    }

}

class AssertionExample {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ur age ");

        int value = scanner.nextInt();
        assert value >= 18 : " Not valid";

        System.out.println("value is " + value);
    }
}
