package Tests.ft;

import Tests.BaseTestCase;
import Tests.object.BCommentPage;
import Tests.object.BCommentTable;
import io.qameta.allure.*;
import org.testng.annotations.Test;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Test4 extends BaseTestCase {


    BCommentTable commentTable = new BCommentTable(driver);
    BCommentPage commentPage = new BCommentPage(driver, commentTable);


    @Test(description = "Deleting of a comments")
    @Description("This test verifies deleting a comments from table")
    @Severity(SeverityLevel.BLOCKER)
    @Epic("Regression Suit")
    @Feature("Comment deletion")
    public void test4() {

        commentPage.open()
                .checkExistingComment(0)
                .verifyDeletingWindowName()
                .verifyDeletingWindowMessage();
        commentTable.verifyCancelDeleteComment();
        commentTable.verifyDeletingCommentWindowClosed();
        commentTable.verifyDeletingComment();
        commentTable.verifyDeletingNotification();
    }


}