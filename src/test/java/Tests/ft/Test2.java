package Tests.ft;

import Tests.BaseTestCase;
import Tests.object.BCommentPage;
import Tests.object.BCommentTable;
import Tests.object.BCommentWindow;
import io.qameta.allure.*;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
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

}
