package Tests.ft;

import Tests.object.BCommentPage;
import Tests.object.BCommentWindow;
import Tests.selenium.BaseTestCase;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test32 extends BaseTestCase {

    private final BCommentWindow commentWindow = new BCommentWindow(this.driver);
    private final BCommentPage commentPage = new BCommentPage(this.driver);

    public Test32() throws IOException {
    }

    @Test(description = "Length validation for name and number strings", enabled = true, groups = "Group1")

    public void test32() {
        commentPage.open();
        commentPage.clickNewComment();
        commentWindow.fillCommentTextField("TESTTEST12TESTTEST12TESTTEST12TESTTEST12TESTTEST122");
        MatcherAssert.assertThat("Wrong error text", commentWindow.isErrorMessageShown("The maximum length of Comment Text field is 50 characters"));
        commentWindow.fillCommentTextField("New CommentText 1000");
        commentWindow.fillCommentNumber("1001");
        commentWindow.saveComment();
        commentWindow.verifyErrorMessage("The Number field should contain value from 0 to 999");
    }

}

