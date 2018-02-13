package net.commments.sample;

public class RoomTwo implements Room {

    public void accept(Person somePerson) {
        System.out.println(somePerson.name() + " went into the room");
    }

    public boolean doesHavePlaces(Person person) {
        return false;
    }
}

