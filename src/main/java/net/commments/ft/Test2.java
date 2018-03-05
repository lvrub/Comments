package net.commments.ft;

import net.commments.object.*;
import net.commments.selenium.CommentsDriver;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

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

    @Test
    public void test() {
        commentPage.open();
        commentTable.checkCommentInTable(0);
        commentPage.clickDuplicate();
        String text = commentWindow.commentText();
        assertEquals(text, "Copy of Comment Text 0");
        String number = commentWindow.commentNumber();
        assertEquals(number, "0");
        String category = commentWindow.selectedCategory();
        assertEquals(category, "Cat0");
        commentWindow.fillCommentNumber("77");
        commentWindow.saveCommentReturnInTable();
        commentPage.navigateToLastPage();
        MatcherAssert.assertThat("Text is correct", commentTable.isCommentTextCorrect("Copy of Comment Text 0"));
        MatcherAssert.assertThat("Number is correct", commentTable.isCommentNumberCorrect("77"));
        MatcherAssert.assertThat("Category is correct", commentTable.isCommentCategoryCorrect("Cat0"));
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
