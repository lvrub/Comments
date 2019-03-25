package JavaExamples.Initialization;

public class A {

    public static String a1 = psv("a1");
    public static String a2 = psv("a2");
    public static String a3 = psv("a3");

    static {
        System.out.println("A class. Static block 1");
    }

    static {
        System.out.println("A class. Static block 2");
    }

    static {
        System.out.println("A class. Static block 3");
    }

    public String a11 = pnsv("a11");
    public String a22 = pnsv("a22");
    public String a33 = pnsv("a33");

    {
        System.out.println("A class. No static block 1");
    }

    {
        System.out.println("A class. No static block 2");
    }

    {
        System.out.println("A class. No static block 3");
    }

    {
        System.out.println("A class. No static block 4");
    }

    {
        String str = "abc";
        System.out.println(str);

        str = str + "def";
        System.out.println(str);

    }

    public A() {
        System.out.println("A class. Constructor");
    }

    private static String psv(String a) {
        System.out.println("A class. Static perem " + a);
        return a;
    }

    private String pnsv(String a) {
        System.out.println("A class. No static perem " + a);
        return a;
    }
}
