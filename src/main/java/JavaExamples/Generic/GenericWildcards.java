package JavaExamples.Generic;

import java.util.ArrayList;
import java.util.List;

public class GenericWildcards {
    public static void main(String arg[]) {
        List<Animal> listOfAnimal = new ArrayList<>();
        listOfAnimal.add(new Animal(1));
        listOfAnimal.add(new Animal(2));

        List<Dog> listOfDogs = new ArrayList<>();
        listOfDogs.add(new Dog(11));
        listOfDogs.add(new Dog(22));

        test(listOfAnimal);

        test(listOfDogs);
    }

    //    private  static void test(List<Animal> list)
    private static void test(List<? extends Animal> list) {
        for (Animal animal : list) {
            animal.eat();
        }

    }
}

