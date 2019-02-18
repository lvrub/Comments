package Tests.ft;

import Tests.object.BCommentPage;
import Tests.object.BCommentTable;
import Tests.object.CommentPage;
import Tests.object.CommentTable;
import io.qameta.allure.*;
import net.commments.sample.selenium.CommentsDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Test4 {
    protected final CommentsDriver driver = new CommentsDriver();
    CommentPage commentPage = new BCommentPage(driver);
    CommentTable commentTable = new BCommentTable(driver);


    @Test(description = "Deleting of a comments")
    @Description("This test verifies deleting a comments from table")
    @Severity(SeverityLevel.BLOCKER)
    @Epic("Regression Suit")
    @Feature("Comment deletion")
    public void test4() {

        commentPage.open();
        commentTable.checkExistingComment(0);
        commentTable.verifyDeletingWindowName();
        commentTable.verifyDeletingWindowMessage();
        commentTable.verifyCancelDeleteComment();
        commentTable.verifyDeletingCommentWindowClosed();
        commentTable.verifyDeletingComment();
        commentTable.verifyDeletingNotification();
    }

    @BeforeMethod
    public void createDriver() throws ExceptionInInitializerError {
        this.driver.define();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void closeDriver() {
        driver.close();
    }

}
