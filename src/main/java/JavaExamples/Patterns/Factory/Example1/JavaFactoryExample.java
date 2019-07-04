package JavaExamples.Patterns.Factory.Example1;

public class JavaFactoryExample {
    /**
     * Now that I’ve created my dog factory, the Dog interface,
     * and all of the dog sub-types, I’ll create a “driver” program
     * named JavaFactoryPatternExample to test the Dog factory. This driver
     * class demonstrates how to get different types of dogs from the factory:
     */
    public static void main(String[] args) {
        // create a small dog
        Dog dog = DogFactory.getDog("small");
        dog.speak();

        // create a big dog
        dog = DogFactory.getDog("big");
        dog.speak();

        // create a working dog
        dog = DogFactory.getDog("working");
        dog.speak();
    }
}
