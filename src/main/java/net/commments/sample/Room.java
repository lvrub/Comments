package net.commments.sample;

public interface Room {

    void accept(Person somePerson);

    boolean doesHavePlaces(Person[] person);
}
