package net.commments.ft;

import net.commments.object.BCommentPage;
import net.commments.object.BCommentWindow;
import net.commments.object.CommentPage;
import net.commments.object.CommentWindow;
import net.commments.selenium.CommentsDriver;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test22 {
    protected final CommentsDriver driver;
    private final CommentPage commentPage;
    private final CommentWindow commentWindow;

    public Test22() {
        this.driver = new CommentsDriver();
        this.commentPage = new BCommentPage(this.driver);   /*why we  need it ?*/
        this.commentWindow = new BCommentWindow(this.driver);
    }

    @Test
    public void test() {
        commentPage.open();
        commentPage.clickNewComment();
        commentWindow.fillCommentTextField("SDFGHJK FGHJK FGHJK ");
        commentWindow.addCategory();
        commentWindow.saveComment();
        MatcherAssert.assertThat("Error is shown",
                commentWindow.isErrorMessageShown("Comment Text field should contain alphanumeric characters only"));
    }

    @BeforeMethod
    public void createDriver() {
        this.driver.define();
    }

    @AfterMethod
    public void closeDriver() {
        this.driver.close();
    }

}
