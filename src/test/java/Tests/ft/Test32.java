package Tests.ft;

import Tests.object.BCommentPage;
import Tests.object.BCommentWindow;
import Tests.object.CommentPage;
import Tests.object.CommentWindow;
import net.commments.sample.selenium.CommentsDriver;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test32 {
    protected final CommentsDriver driver;
    private final CommentWindow commentWindow;
    private final CommentPage commentPage;

    public Test32() {
        this.driver = new CommentsDriver();
        this.commentWindow = new BCommentWindow(this.driver);
        this.commentPage = new BCommentPage(this.driver);

    }

    @BeforeMethod
    public void createDriver() {
        this.driver.define();
        commentPage.open();
        commentPage.clickNewComment();

    }

    @Test(description = "Length validation for name and number strings", enabled = true)

    public void test() {
        commentWindow.fillCommentTextField("TESTTEST12TESTTEST12TESTTEST12TESTTEST12TESTTEST122");
        MatcherAssert.assertThat("Wrong error text", commentWindow.isErrorMessageShown("The maximum length of Comment Text field is 50 characters"));
        commentWindow.fillCommentTextField("New CommentText 1000");
        commentWindow.fillCommentNumber("1001");
        commentWindow.saveComment();
        MatcherAssert.assertThat(commentWindow.showErrorMessage(), Matchers.is("The Number field should contain value from 0 to 999"));
    }

    @AfterMethod
    public void closeDriver() {
        this.driver.close();
    }
}

