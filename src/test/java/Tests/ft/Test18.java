package Tests.ft;

import Tests.BaseTestCase;
import Tests.object.BCommentPage;
import Tests.object.BCommentTable;
import Tests.object.BCommentWindow;
import io.qameta.allure.*;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test18 extends BaseTestCase {

    public final BCommentPage commentPage = new BCommentPage(this.driver);
    public final BCommentWindow commentWindow = new BCommentWindow(this.driver);
    public final BCommentTable commentTable = new BCommentTable(this.driver);

    @Test(dataProvider = "Name", description = "Comments saving with different valid name")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test checks saving of comment with valid name")
    @Epic("Regression Suit")
    @Feature("Comment name")
    public void test18(String name) {
        commentPage.open();
        commentPage.clickNewComment();
        commentWindow.fillCommentTextField(name);
        commentWindow.addCategory();
        commentWindow.fillCommentNumber("111");
        commentWindow.saveCommentReturnInTable();
        commentPage.navigateToLastPage();

        MatcherAssert.assertThat(commentTable.verifyCommentId(""), Matchers.is("111"));
        MatcherAssert.assertThat(name + " is present", commentTable.isNewCommentTextCorrect(name));

    }

    @DataProvider
    public Object[][] Name() {
        return new Object[][]{
                {"Loasdwd"},
                {"удлатл"},
                {"123423"},
                {"âãäåçèéêëìíîðñò"}
        };
    }
}
