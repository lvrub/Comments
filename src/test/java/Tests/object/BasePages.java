package Tests.object;

import Tests.selenium.UIMapParser;

import java.io.IOException;

public class BasePages {

    public UIMapParser parser = new UIMapParser("C:\\Automation\\src\\test\\java\\Tests\\selenium\\UIMap.properties");

    public <T extends BasePages> T returnPage(T page) {
        return page;
    }

    public BasePages() throws IOException {
    }

//    public BCommentTable returnTableContext(BCommentTable commentTable) {
//        return (commentTable);
//    }


}
