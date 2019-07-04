package JavaExamples.Patterns.Factory.Example2;

import static JavaExamples.Patterns.Factory.Example2.DoughnutTypes.*;

public class Main {
    public static void main(String[] args) {

        DoughnutFactory factory = new DoughnutFactory();

        Doughnut cherry = factory.getDoughnut(CHERRY);
        Doughnut chocolate = factory.getDoughnut(CHOCOLATE);
        Doughnut almond = factory.getDoughnut(ALMOND);

        cherry.eat();
        chocolate.eat();
        almond.eat();
    }
}