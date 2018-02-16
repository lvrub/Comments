package net.commments.sample;

public class RoomOne implements Room {

    private final int size;
    private int capacity = 0;

    public RoomOne(int size) {
        this.size = size;
    }

    public void accept(Person somePerson) {

        if (this.capacity < this.size) {
            System.out.println("Hi " + somePerson.name() + ", please come to the room " + (this.size - this.capacity) + "(place(s) are free)");
            this.capacity++;
        } else {
            System.out.println("Hi " + somePerson.name() + ", unfortunately there are no free places.Please go to RoomTwo ");
        }

    }
}


