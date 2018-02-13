package net.commments.sample;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class AttentetiveStudentTest {
    @Test
    public void checkAttentiveSudentName() {

        AttentetiveStudent student = new AttentetiveStudent("leonid");
        String name = student.name();
        MatcherAssert.assertThat(name, Matchers.is("leonid"));

        // MatcherAssert.assertThat(new AttentetiveStudent("leonid").name(), Matchers.is("leonid"));
    }
}
