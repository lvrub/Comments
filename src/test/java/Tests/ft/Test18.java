package Tests.ft;

import Tests.object.*;
import io.qameta.allure.*;
import net.commments.sample.selenium.CommentsDriver;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test18 {
    public final CommentsDriver driver;
    public final CommentPage commentPage;
    public final CommentWindow commentWindow;
    public final CommentTable commentTable;


    public Test18() {
        this.driver = new CommentsDriver();
        commentPage = new BCommentPage(this.driver);
        commentWindow = new BCommentWindow(this.driver);
        commentTable = new BCommentTable(this.driver);

    }

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

    @BeforeMethod
    public void createDriver() {
        this.driver.define();
    }

    @AfterMethod
    public void closeDriver() {
        this.driver.close();
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
