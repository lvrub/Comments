package JavaExamples;

public class Main1 {
    public static void main(String[] arg) throws Exception1 {
        Fruit f = new Mango();
        f.eatMe();
    }

}

class Fruit {
    public void eatMe() throws Exception2 {
        System.out.println("Eatt fruits");
    }
}

class Mango extends Fruit {
    public void eatMe() {
        System.out.println("Eat mango");
    }

}

class Exception1 extends Exception {
}

class Exception2 extends Exception1 {
}