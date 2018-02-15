package net.commments.sample;

public class RoomOne implements Room {

    private final int size;
    private int capacity = 0;

    public RoomOne(int size) {
        this.size = size;
    }

//        ArrayList student =new ArrayList();

    public void accept(Person somePerson) {
//        for (int i=0; i<=2;i++){
//             System.out.println("hello" + student.get(i).toString());
        //
        // }


        this.capacity++;
        if (this.capacity <= this.size) {
            System.out.println("Hi " + somePerson.name() + ", please come to the room " + (this.size - this.capacity) + "(place(s) are free)");
        } else {
            System.out.println("Hi " + somePerson.name() + ", unfortunately there are no free places.Please go to RoomTwo ");
        }

    }
}


