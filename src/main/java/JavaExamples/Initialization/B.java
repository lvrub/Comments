package JavaExamples.Initialization;

public class B extends A {

    static String st = A.psv("st_atatic");

    static {
        System.out.println("B class.Child Static block 1");
    }

    private int b = bb(20);

    public B(int b) {
        this.b = b;
    }

    public B() {
        System.out.println("B class.Child Constructor");
    }

    private int bb(int x) {
        System.out.println("B class.Child No static perem " + x);
        return 0;
    }

}
