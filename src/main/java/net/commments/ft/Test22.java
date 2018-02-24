package net.commments.ft;

import net.commments.object.BCommentPage;
import net.commments.object.BCommentWindow;
import net.commments.object.CommentPage;
import net.commments.object.CommentWindow;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Test22 extends BaseDriver {


    private final CommentPage commentPage;
    private final CommentWindow commentWindow;

    public Test22() {
        super();
        this.commentPage = new BCommentPage(this.driver);   /*why we  need it ?*/
        this.commentWindow = new BCommentWindow(this.driver);
    }

    @Test
    public void test() {
        commentPage.open();
        commentPage.clickNewComment();
        commentWindow.fillCommentTextField("!@#$%^&*+_)(*&");
        commentWindow.saveComment();
        String errorText = commentWindow.showErrorMessage();
        assertEquals(errorText, "The Comment Text field should contain alphanumeric characters only");
    }

//    @BeforeMethod
//    public void createDriver() {
//        driver[0] = new ChromeDriver();
//    }
//
//    @AfterMethod
//    public void closeDriver() {
//        driver[0].quit();
//    }
//
//    private WebDriver driver() {
//        return this.driver[0];
//    }
}
