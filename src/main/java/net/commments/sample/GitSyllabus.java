package net.commments.sample;

public class GitSyllabus implements Subject {
    public void teachedBy(Teacher teacher) {
        System.out.println(teacher.name() + " teaches GIT");
    }

    public void studiedBy(Student student) {
        System.out.println(student.name() + " receives GIT knowledge");
    }
}
