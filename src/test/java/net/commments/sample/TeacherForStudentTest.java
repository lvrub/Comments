package net.commments.sample;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class TeacherForStudentTest {

    @Test
    public void checkTeacherName() {
        Teacher olga = new TeacherForStudent("Olga");
        String name = olga.name();
        MatcherAssert.assertThat(name, Matchers.is("Olga"));
    }
}