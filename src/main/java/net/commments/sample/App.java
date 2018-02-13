package net.commments.sample;

public class App {
    public static void main(String[] args) {

        Student andrey = new AttentetiveStudent("Andrey");
        Student nastya = new AttentetiveStudent("Nastya");
        Student dima = new BadStudent("Dima");
        Teacher petrova = new TeacherForStudent("Olga Petrova");
        Teacher ivanova = new TeacherForStudent("Olga Ivanova");
        //RoomOne a;    or RoomOne a =  new RoomOne();
        //a= new RoomOne();
        Room room = new RoomOne();

        Subject git = new GitSyllabus();
        Subject cake = new BakeCake();

        room.accept(andrey);
        room.accept(nastya);
        room.accept(dima);
        go(andrey, git);
        go(nastya, cake);
        go(dima, git);
        do_1(petrova, git);
        do_1(ivanova, cake);

    }

    private static void go(Student someone, Subject subject) {
        System.out.println(String.format("This is %s in the room!", someone.name()));
        someone.learn(subject);
    }

    private static void do_1(Teacher person, Subject subject) {
        System.out.println(String.format("The teacher %s is in the room too!", person.name()));
        person.teach(subject);
    }





    /*private static void enter(Person room) {
        String text = (room.name() + " went into the room");
        System.out.println(text);
    }*/

}
