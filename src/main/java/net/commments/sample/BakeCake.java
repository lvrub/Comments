package net.commments.sample;

public class BakeCake implements Subject {
    public void teachedBy(Teacher teacher) {
        System.out.println(teacher.name() + " teaches how to bake a cake");
    }

    public void studiedBy(Student student) {
        System.out.println(student.name() + " receives knowledge about backing a cake");
    }
}
