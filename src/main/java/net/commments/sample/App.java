package net.commments.sample;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Student andrey = new AttentetiveStudent("Andrey");
        Student nastya = new AttentetiveStudent("Nastya");
        Student dima = new BadStudent("Dima");
        Teacher petrova = new TeacherForStudent("Petrova ");
        Teacher ivanova = new TeacherForStudent("Ivanova ");

        Grade grade = new ReceivedGrade(2);
        Room room = new RoomOne(2);
        Subject git = new GitSyllabus();
        Subject cake = new BakeCake();


        List<Student> student = new ArrayList();
        student.add(andrey);
        student.add(nastya);
        student.add(dima);

        for (int i = 0; i < student.size(); i++) {
            room.accept(student.get(i));
            come(student.get(i), git);
            grade.getByStudent(student.get(i));
        }

        List<Teacher> teacher = new ArrayList();
        teacher.add(petrova);
        teacher.add(ivanova);

        do1(teacher.get(0), git);
        do1(teacher.get(1), cake);

    }

    private static void come(Student someone, Subject subject) {
        System.out.println(String.format("This is %s in the room!", someone.name()));
        someone.learn(subject);
    }

    private static void do1(Teacher person, Subject subject) {
        System.out.println(String.format("The teacher %s is in the room too!", person.name()));
        person.teach(subject);
    }

}
