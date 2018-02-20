package net.commments.sample;

public class ReceivedGrade implements Grade {
    private final int grade;

    public ReceivedGrade(int grade) {
        this.grade = grade;
    }

    public void getByStudent(Student student) {
        if (this.grade == 2) {
            System.out.println("You reciaved " + this.grade + student.name());
        }
    }

}
