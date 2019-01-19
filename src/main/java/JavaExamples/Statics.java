package JavaExamples;

public class Statics {
    static int a;

    static void firstMethod(int a) {
//        this.a=a;
        System.out.println("Это статический метод!");
    }

    public void secondMethod(int a) {
//        this.a=a;
        System.out.println("Это НЕ статический метод!");
    }
}

class Test {
    public static void main(String args[]) {
        Statics c1 = new Statics();

        Statics.firstMethod(11);
        c1.secondMethod(11);
    }

}

//class Test1 {
//
//    public static void main (String args[]){
//
//        Statics.firstMethod();
//        Statics.secondMethod();
//    }
//
//}
