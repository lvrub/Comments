package JavaExamples.Patterns.Factory.Example1;

/*Next I’ll define my Java “Factory” class, which in this case is
 a DogFactory class. As you can see from the code below,
 the DogFactory class has a static getDog method that returns
 a Dog that depends on the criteria that has been supplied.*/
class DogFactory {
    /*As I mentioned, the signature of my Java factory method states
     that I’ll be returning a class of type Dog:*/
    public static Dog getDog(String criteria) {
        if (criteria.equals("small"))
            return new Poodle();

        else if (criteria.equals("big"))
            return new Rottweiler();

        else if (criteria.equals("working"))
            return new SiberianHusky();

        return null;
    }
}