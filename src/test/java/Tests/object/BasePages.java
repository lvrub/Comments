package Tests.object;

import org.openqa.selenium.WebDriver;

public class BasePages {

    private WebDriver driver;

    public BCommentPage returnPageContext(BCommentPage commentPage) {
        return (commentPage);
    }

    public BCommentTable returnTableContext(BCommentTable commentTable) {
        return (commentTable);
    }
}
