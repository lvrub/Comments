package JavaExamples.Initialization;

public class B extends A {
    static {
        System.out.println("B class. Static block 1");
    }

    private int b = bb(20);

    public B(int b) {
        this.b = b;
    }

    public B() {
        System.out.println("B class. Constructor");
    }

    private int bb(int x) {
        System.out.println("B class. No static perem " + x);
        return 0;
    }

}
