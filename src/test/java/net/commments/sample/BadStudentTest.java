package net.commments.sample;

import io.qameta.allure.Epic;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class BadStudentTest {
    @Test
    @Epic("Unit Tests")

    public void checkBadStudentName() {
        BadStudent student = new BadStudent("vova");
        String name = student.name();
        MatcherAssert.assertThat(name, Matchers.is("vova"));
    }
}