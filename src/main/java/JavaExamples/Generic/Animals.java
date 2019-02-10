package JavaExamples.Generic;

import java.util.ArrayList;
import java.util.List;

public class Animals {
    public static void main(String arg[]) {
        ////////////////////java 5/////////////////
        List animals = new ArrayList();
//        Animal animalClass = new Animal();

        animals.add("Cat");
        animals.add("Dog");
        animals.add("Frog");
//        animals.add(animalClass);

        String animal = (String) animals.get(1);
        System.out.println(animal);

        ////////////after java 5//////////
        List<String> animals_1 = new ArrayList<String>();

        animals_1.add("Cat");
        animals_1.add("Dog");
        animals_1.add("Frog");
//        animals_1.add(animalClass); not allowed

        String animal1 = (String) animals.get(1);
        System.out.println(animal1);
////////////////////Java 7////////////////
        List<String> animals_2 = new ArrayList<String>();

    }
}

class Animal {
    private int id;

    Animal(int id) {
        this.id = id;
    }

    public void eat() {
        System.out.println("I am eating");
    }
// public String toString(){
//        return String.valueOf(id);
//    }
}