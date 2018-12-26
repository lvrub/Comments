package JavaExamples;

class DoWhileDemo {
    public static void main(String[] args) {
        int count = 1;
        do {
            count++;
            System.out.println("Count is: " + count);
            count++;
        } while (count < 11);
    }
}