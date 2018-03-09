package Tests.ft;

import Tests.object.*;
import io.qameta.allure.*;
import net.commments.sample.selenium.CommentsDriver;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test2 {
    protected final CommentsDriver driver;
    protected final CommentPage commentPage;
    protected final CommentTable commentTable;
    protected final CommentWindow commentWindow;

    public Test2() {
        this.driver = new CommentsDriver();
        commentTable = new BCommentTable(driver);
        commentPage = new BCommentPage(driver);
        commentWindow = new BCommentWindow(driver);
    }

    @Test(description = "Verify duplication of comment")
    @Description("This test verifies that uset is able to duplicate a comment")
    @Severity(SeverityLevel.NORMAL)
    @Epic("Regression Suit")
    @Feature("Duplication of a comment")
    public void test() {
        commentPage.open();
        commentTable.checkExistingComment(0);
        commentPage.clickDuplicate();
        MatcherAssert.assertThat(commentWindow.commentText(), Matchers.is("Copy of Comment Text 0"));
        MatcherAssert.assertThat(commentWindow.commentNumber(), Matchers.is("0"));
        MatcherAssert.assertThat(commentWindow.selectedCategory(), Matchers.is("Cat0"));
        commentWindow.fillCommentNumber("77");
        commentWindow.saveCommentReturnInTable();
        commentPage.navigateToLastPage();
        MatcherAssert.assertThat("Text is correct", commentTable.isNewCommentTextCorrect("Copy of Comment Text 0"));
        MatcherAssert.assertThat("Number is correct", commentTable.isNewCommentNumberCorrect("77"));
        MatcherAssert.assertThat("Category is correct", commentTable.isNewCommentCategoryCorrect("Cat0"));
    }

    @AfterMethod
    public void closeDriver() {
        this.driver.quit();
    }

    @BeforeMethod
    public void createDriver() {
        this.driver.define();
    }

}
