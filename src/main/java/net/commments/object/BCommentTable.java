package net.commments.object;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class BCommentTable implements CommentTable {
    private final WebDriver driver;

    public BCommentTable(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void checkCommentInTable(int numberComment) {
        this.driver.findElements(By.name("SelectedId")).get(numberComment).click();
    }

    public String commentStatus() {
        return this.driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[5]/form/table/tbody/tr[1]/td[4]")).getText();
    }

    public boolean isCommentNumberCorrect(String number) {
        try {
            String s = this.driver.findElement(By.xpath(String.format("//td[@class='numbercolumn'and contains(text(),'%s')]", number))).getText();
            System.out.println(s + " 77 must be isCommentNumberCorrect ");
            return true;
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean isCommentTextCorrect(String name) {
        try {
            this.driver.findElement(By.xpath(String.format("//*[@class='textcolumn'][contains(text(),\"%s\")]", name)));
            return true;
        } catch (NoSuchElementException e) {
        }
        return false;
    }


    public boolean isCommentCategoryCorrect(String category) {
        try {
            String s = this.driver.findElement(By.xpath(String.format("//*[@class='categorycolumn' and contains(text(), '%s')]", category))).getText();
            System.out.println(s + " isCommentCategoryCorrect ");
            return true;
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean isCommentInactive(String state) {
        try {
            this.driver.findElement(By.xpath(String.format("//tr[1]/td[@class='inactivecolumn' and contains(text(), \"%s\")]", state)));
            System.out.println(state);
            return true;
        } catch (NoSuchElementException e) {
            System.out.println(e);
            return false;
        }
    }

}


