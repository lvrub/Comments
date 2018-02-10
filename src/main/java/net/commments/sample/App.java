package net.commments.sample;

public class App {
    public static void main(String[] args) {

        Student andrey = new AttentetiveStudent("Andrey");
        Student nastya = new AttentetiveStudent("Nastya");
        Student dima = new BadStudent("Dima");
        Teacher petrova = new TeacherForStudent("Olga Petrova");
        Teacher ivanova = new TeacherForStudent("Olga Ivanova");
        //RoomImplementaton a;    or RoomImplementaton a =  new RoomImplementaton();
        //a= new RoomImplementaton();
        Room room = new RoomImplementaton();
        go(andrey);
        go(nastya);
        go(dima);
        do_1(petrova);
        do_1(ivanova);
        enter(andrey);
        enter(nastya);
        enter(dima);

    }

    private static void go(Student someone) {
        System.out.println(String.format("This is %s in the room!", someone.name()));
        someone.learn();
    }

    private static void do_1(Teacher person) {
        System.out.println(String.format("The teacher %s is in the room too!", person.name()));
        person.teach();
    }

    private static void enter(Person room) {
        String text = (room.name() + " went into the room");
        System.out.println(text);
    }

}
