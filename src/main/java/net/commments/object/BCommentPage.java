package net.commments.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BCommentPage implements CommentPage {
    private final WebDriver driver;

    public BCommentPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void open() {
        this.driver.get("http://commentssprintone.azurewebsites.net/");
    }

    public void clickNewComment() {
        this.driver.findElement(By.id("newbutton")).click();
        this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void navigateToLastPage() {
        String s = this.driver.findElement(By.xpath("//td[@colspan='5']")).getText();
        System.out.println(s);
        String[] pages = s.split(" ");
        for (String s1 : pages)
            System.out.println(s1);
        String s2 = pages[pages.length - 2];
        System.out.println(s2);
        String page = s2;
        this.driver.findElement(By.xpath(String.format("//a[@href='/?page=%s']", page))).click();
    }

    public void clickDuplicate() {
        this.driver.findElement(By.xpath("//*[@id='command-navigation']/input[1]")).click();
    }
}
