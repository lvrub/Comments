package Tests.ft;

import Tests.object.BCommentPage;
import Tests.object.BCommentTable;
import Tests.selenium.BaseTestCase;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class Test4 extends BaseTestCase {

    BCommentTable commentTable = new BCommentTable(driver);
    BCommentPage commentPage = new BCommentPage(driver);

    @Test(description = "Deleting of a comments")
    @Description("This test verifies deleting a comments from table")
    @Severity(SeverityLevel.BLOCKER)
    @Epic("Regression Suit")
    @Feature("Comment deletion")
    public void test4() {

        commentPage.open()
                .verifyAlertMessageForDeleting()
                .closeAlertForDeleting()
                .returnPage(commentTable)
                .checkExistingComment(0)
                .verifyHeaderClickable("Comment Text")
                .verifyHeaderClickable("Number")
                .verifyHeaderClickable("Inactive")
                .returnPage(commentPage)
                .verifyDeletingWindowName()
                .verifyDeletingWindowMessage()
                .verifyCancelDeleteComment()
                .verifyDeletingCommentWindowClosed()
                .verifyDeletingComment()
                .verifyDeletingNotification();
    }

}