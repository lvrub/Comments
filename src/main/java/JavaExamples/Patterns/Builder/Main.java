package JavaExamples.Patterns.Builder;

public class Main {
    public static void main(String arf[]) {
        final Contact contact = new ContactBuilder()
                .name("Andre")
                .surname("Ivanoc")
                .address("Dnipro 25")
                .phone("123-765-766")
                .mail("khbjhg@jlk.ii")
                .build();

        final Contact contact1 = new ContactBuilder()
                .name("Olha")
//                .surname("")
                .build();
    }

}
