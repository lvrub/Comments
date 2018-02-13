package net.commments.sample;

public class RoomOne implements Room {

    public void accept(Person somePerson) {
        System.out.println(somePerson.name() + " went into the room");
    }

    public boolean doesHavePlaces() {
        return true;
    }
}

