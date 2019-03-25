package Tests.ft;

import Tests.object.BCommentPage;
import Tests.object.BCommentWindow;
import Tests.selenium.BaseTestCase;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test22 extends BaseTestCase {

    private final BCommentPage commentPage = new BCommentPage(this.driver);
    private final BCommentWindow commentWindow = new BCommentWindow(this.driver);

    @Test(dataProvider = "Data1", description = "Comment saving with special characters", enabled = true)
    @Severity(SeverityLevel.MINOR)
    @Description("This test checks saving of comment with name containing special characters")
    @Epic("Regression Suit")
    @Feature("Comment name validation")

    public void test(String text, String errorMessage) {
        commentPage.open()
                .clickNewComment()
                .returnPage(commentWindow)
                .fillCommentTextField(text)
                .addCategory()
                .saveComment()
                .verifyErrorMessage(errorMessage);
    }

    @DataProvider
    public Object[][] Data1() {
        return new Object[][]{
                {"!@#$%^&*", "The Comment Text field should contain alphanumeric characters only"},
                {"ернорлдлор", "Please, select at least one category"}
        };
    }
}
