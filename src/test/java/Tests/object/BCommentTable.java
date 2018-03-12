package Tests.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BCommentTable implements CommentTable {
    private final WebDriver driver;

    public BCommentTable(WebDriver webDriver) {
        this.driver = webDriver;
    }

    @Step("Check comment check-box in table")
    public void checkExistingComment(int numberComment) {
        this.driver.findElements(By.name("SelectedId")).get(numberComment).click();
    }

    @Step("Check inactivate comment status in table")
    public String commentStatus() {
        return this.driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[5]/form/table/tbody/tr[1]/td[4]")).getText();
    }

    @Step("Verify comment number in table")
    public boolean isNewCommentNumberCorrect(String number) {
        try {
            this.driver.findElement(By.xpath(String.format("//td[@class='numbercolumn'and contains(text(),'%s')]", number))).getText();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Verify comment name in table")
    public boolean isNewCommentTextCorrect(String name) {
        try {
            this.driver.findElement(By.xpath(String.format("//*[@class='textcolumn'][contains(text(),\"%s\")]", name)));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void commentNames() {
        List<String> names = new ArrayList<>();
        for (WebElement element : driver.findElements(By.xpath("//td[@class='textcolumn']"))) {
            names.add(element.getText());
            System.out.println(names);
        }
    }

    @Step("Verify comment category in table")
    public boolean isNewCommentCategoryCorrect(String category) {
        try {
            String s = this.driver.findElement(By.xpath(String.format("//*[@class='categorycolumn' and contains(text(), '%s')]", category))).getText();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Verify comment inactivation in table")
    public boolean isCommentInactive(String state) {
        try {
            this.driver.findElement(By.xpath(String.format("//tr[1]/td[@class='inactivecolumn' and contains(text(), \"%s\")]", state)));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}


