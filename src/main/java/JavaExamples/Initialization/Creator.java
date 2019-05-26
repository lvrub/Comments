package JavaExamples.Initialization;

class Car1 {
    Engine engine;

    public Car1() {
    }

    public Car1(Engine engine) {
        this.engine = engine;
    }

}

class Engine {
    int cylinders;
    double power;

    public Engine(int cylinders, double power) {
        this.cylinders = cylinders;
        this.power = power;
    }
}


public class Creator {

    public static void main(String arg[]) {
        Engine engine_1 = new Engine(10, 150);

        Car1 car_1 = new Car1(new Engine(8, 123.88));
        Car1 car_2 = new Car1(engine_1);
        Car1 car_3 = new Car1();


        System.out.println(car_1.engine.cylinders + "; " + car_1.engine.power);
        System.out.println(car_2.engine.cylinders + "; " + car_2.engine.power);
        System.out.println(car_3.engine);

    }
}
