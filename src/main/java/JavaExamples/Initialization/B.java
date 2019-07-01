package JavaExamples.Initialization;

public class B extends A {
    static {
        System.out.println("B class. Static block 1");
    }

    private int b = bb(20);
//    private int c = bb(40);


    public B(int b) {
        this.b = b;
        System.out.println("B class. First Constructor");
    }

//    public B(int b, int c) {
//        this(b);
//        this.c= c;
//        System.out.println("B class. Third Constructor");
//    }

    public B() {
        System.out.println("B class. Second Constructor");
    }

    private int bb(int x) {
        System.out.println("B class. No static perem " + x);
        return 0;
    }

}
