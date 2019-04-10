package JavaExamples;

final class Immutable {
    final private String string;

    private Immutable(String string) {
        this.string = string;
    }

    public static void main(String arg[]) {
        Immutable immutable = new Immutable("New+++");
        String string = immutable.getString().replaceAll("New", "Old");
        String string1 = immutable.getString().toUpperCase();
        System.out.println(immutable.string);
        System.out.println(string);
        System.out.println(string1);
    }

//    public void setString(String string) {
//        this.string = string;
//    }

    public String getString() {
        return string;
    }
}
