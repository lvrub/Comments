package net.commments.sample;

public class TeacherForStudent implements Teacher {
    private final String teacher;

    public TeacherForStudent(String name) {
        teacher = name;
    }

    public void teach(Subject subject) {
        subject.teachedBy(this);
    }

    public String name() {
        return teacher;
    }

}
