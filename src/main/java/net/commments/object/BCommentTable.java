package net.commments.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BCommentTable implements CommentTable {
    private final WebDriver driver;

    public BCommentTable(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void checkCommentInTable(int numberComment) {
        this.driver.findElements(By.name("SelectedId")).get(numberComment).click();
    }


    public String checkActiveStatus() {
        return this.driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[5]/form/table/tbody/tr[1]/td[4]")).getText();

    }
}