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
        String[] TwoTrainings = new String[2];
        TwoTrainings[0] = "TrainerOne";
        TwoTrainings[1] = "TrainerTwo";

        Subject git = new GitSyllabus();
        //Subject cake = new BakeCake();

        go(andrey, git);
        go(nastya, git);
        go(dima, git);
        room.accept(andrey);
        room.accept(nastya);
        room.accept(dima);
        do_1(petrova, git);
        do_1(ivanova, git);
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
