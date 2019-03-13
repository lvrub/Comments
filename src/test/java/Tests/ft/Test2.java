package Tests.ft;

import Tests.object.BCommentPage;
import Tests.object.BCommentTable;
import Tests.object.BCommentWindow;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class Test2 extends BaseTestCase {

    protected final BCommentPage commentPage = new BCommentPage(driver);
    protected final BCommentTable commentTable = new BCommentTable(driver);
    protected final BCommentWindow commentWindow = new BCommentWindow(driver);


    @Test(description = "Verify duplication of comment", groups = "New" /*,dependsOnMethods = "Tests.ft.Test32.test32"*/)
    @Description("This test verifies that uset is able to duplicate a comment")
    @Severity(SeverityLevel.NORMAL)
    @Epic("Regression Suit")
    @Feature("Duplication of a comment")

    public void test2() {
        commentPage.
                open()
                .returnPage(commentTable)
                .checkExistingComment(0)
                .returnPage(commentPage)
                .clickDuplicate()
                .returnPage(commentWindow)
                .verifyCommentText("Copy of Comment Text 0")
                .verifyCommentNumber("0")
                .verifyCommentCategory("Cat0")
                .fillCommentNumber("77")
                .saveCommentReturnInTable()
                .returnPage(commentPage)
                .navigateToLastPage()
                .returnPage(commentTable)
                .verifyCommentTextCorrect("Copy of Comment Text 0")
                .isNewCommentNumberCorrect("77", "77")
                .isNewCommentCategoryCorrect("Cat0", "Cat0");
    }

}
