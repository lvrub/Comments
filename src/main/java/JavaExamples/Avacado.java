package JavaExamples;

public class Avacado {

    static public void main(String[] arg) {
        Avacado avacado = new Avacado();
        avacado.split("avacado");
    }

    protected void split(String text) {
        String[] split = text.split("a");
        for (String sp : split) {
            System.out.println(sp);
//            System.out.println(sp.length());
        }
    }
}