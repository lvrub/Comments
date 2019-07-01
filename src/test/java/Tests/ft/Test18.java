package Tests.ft;

import Tests.object.BCommentPage;
import Tests.object.BCommentTable;
import Tests.object.BCommentWindow;
import Tests.selenium.BaseTestCase;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

//@ITestListeners(Tests.selenium.ITestListeners.class)


public class Test18 extends BaseTestCase {

    public final BCommentPage commentPage = new BCommentPage(this.driver);
    public final BCommentWindow commentWindow = new BCommentWindow(this.driver);
    public final BCommentTable commentTable = new BCommentTable(this.driver);


    public Test18() throws IOException {
    }

    @Test(dataProvider = "commentName", description = "Comments saving with different valid name")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test checks saving of comment with valid name")
    @Epic("Regression Suit")
    @Feature("Comment name")


    public void test18(String name) {
        commentPage.open()
                .clickNewComment()
                .returnPage(commentWindow)
                .fillCommentTextField(name)
                .fillCommentNumber("111")
                .addCategory()
                .saveCommentReturnInTable()
                .returnPage(commentPage)
                .navigateToLastPage()
                .returnPage(commentTable)
                .verifyCommentId("111")
                .verifyCommentText(name, name);
    }

    @DataProvider(name = "commentName")
    public Object[][] Name() {
        return new Object[][]{
                {"Loasdwd"},
                {"удлатл"},
                {"123423"},
                {"âãäåçèéêëìíîðñò"}
        };
    }
}
