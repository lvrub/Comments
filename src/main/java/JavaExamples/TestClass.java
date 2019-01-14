package JavaExamples;

class TestClass {
    private int a = 10;

    private int b;

    int c() {
        return a + b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }
}

class TestClass1 {
    private String classRoom1;
    private int number;

    public TestClass1(String classRoom, int number) {
        this.classRoom1 = classRoom;
        this.number = number;
    }

    public String getName() {
        return classRoom1;
    }

    public Integer getNumber() {
        return number;
    }
}


class Main {
    public static void main(String[] args) {
        TestClass test = new TestClass();
        TestClass1 test1 = new TestClass1("MerryRoom", 33);
        TestClass0 testClass0 = new TestClass0();
        TestClass1 test3 = new TestClass1(testClass0.b(), testClass0.a());
        test.setA(11);
        test.setB(30);
        System.out.println(test1.getName() + '\n' + test1.getNumber());
        System.out.println(test3.getName() + '\n' + test3.getNumber());
        System.out.println(test.getA());
        System.out.println(test.c());

    }
}
