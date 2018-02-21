package net.commments.sample;

public class ReceivedGrade implements Grade {
    private final String grade;

    public ReceivedGrade(String grade) {
        this.grade = grade;
    }

    public void getByStudent(Grade grade, Student student) {
        if (this.grade == "A") {
            System.out.println(student.name() + " you are the best " + "your grade is " + this.grade);
        }
        if (this.grade == "B") {
            System.out.println(student.name() + " you are good " + "your grade is " + this.grade);
        }
        if (this.grade == "C") {
            System.out.println(student.name() + " you are not good " + "your grade is " + this.grade);
        }
    }

//    public String grade() {
//    return this.grade;
//    }
}

