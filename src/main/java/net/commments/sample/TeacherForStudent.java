package net.commments.sample;

public class TeacherForStudent implements Teacher {
    private final String teacher;

    public TeacherForStudent(String name) {
        teacher = name;
    }

    public void teach() {
        System.out.println(teacher + " is teacher for all student");
    }

    public String name() {
        return teacher;


    }

}
