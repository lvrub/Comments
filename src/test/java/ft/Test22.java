package ft;

import object.BCommentPage;
import object.BCommentWindow;
import object.CommentPage;
import object.CommentWindow;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.CommentsDriver;

public class Test22 {
    protected final CommentsDriver driver;
    private final CommentPage commentPage;
    private final CommentWindow commentWindow;

    public Test22() {
        this.driver = new CommentsDriver();
        this.commentPage = new BCommentPage(this.driver);   /*why we  need it ?*/
        this.commentWindow = new BCommentWindow(this.driver);
    }

    @Test(dataProvider = "Data1", priority = 3, description = "Comment saving with special characters")
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
                {"ернорлдлор", "The Comment Text field should contain alphanumeric characters only"}

        };
    }
}
