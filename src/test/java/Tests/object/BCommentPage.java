package Tests.object;

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
        String[] pages = s.split(" ");
        this.driver.findElement(By.xpath(String.format("//a[@href='/?page=%s']", pages.length - 1))).click();
    }

    public void clickDuplicate() {
        this.driver.findElement(By.xpath("//*[@id='command-navigation']/input[1]")).click();
    }
}