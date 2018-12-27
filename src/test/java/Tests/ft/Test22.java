package Tests.ft;

import Tests.object.BCommentPage;
import Tests.object.BCommentWindow;
import Tests.object.CommentPage;
import Tests.object.CommentWindow;
import io.qameta.allure.*;
import net.commments.sample.selenium.CommentsDriver;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test22 {
    protected final CommentsDriver driver;
    private final CommentPage commentPage;
    private final CommentWindow commentWindow;

    public Test22() {
        this.driver = new CommentsDriver();
        this.commentPage = new BCommentPage(this.driver);   /*why we  need it ?*/
        this.commentWindow = new BCommentWindow(this.driver);
    }

    @Test(dataProvider = "Data1", description = "Comment saving with special characters", enabled = false)
    @Severity(SeverityLevel.MINOR)
    @Description("This test checks saving of comment with name containing special characters")
    @Epic("Regression Suit")
    @Feature("Comment name validation")
    public void test(String text, String errorMessage) {
        commentPage.open();
        commentPage.clickNewComment();
        commentWindow.fillCommentTextField(text);
        commentWindow.addCategory();
        commentWindow.saveComment();
        MatcherAssert.assertThat(commentWindow.showErrorMessage(), Matchers.is(errorMessage));
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
    public Object[][] Data1() {
        return new Object[][]{
                {"!@#$%^&*", "The Comment Text field should contain alphanumeric characters only"},
                {"ернорлдлор", "Please, select at least one category"}
        };
    }
}
