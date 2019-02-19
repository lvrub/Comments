package Tests.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BCommentPage {// implements CommentPage {
    private final WebDriver driver;
    private BCommentTable bCommentTable;

    public BCommentPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public BCommentPage(WebDriver webDriver, BCommentTable bCommentTable) {
        this.driver = webDriver;
        this.bCommentTable = bCommentTable;
    }

    @Step("Open comments site")
    public BCommentTable open() {
        driver.get("http://commentssprintone.azurewebsites.net");
        return bCommentTable;
    }

    @Step("Open window for new comments ")
    public void clickNewComment() {
        this.driver.findElement(By.id("newbutton")).click();
        this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Step("Go to last table page")
    public void navigateToLastPage() {
        this.driver.findElement(By.xpath("//a[contains(@href,\"page\")][last()-1]")).click();
    }

    @Step("Open window for new comment with duplicated existing info")
    public void clickDuplicate() {
        this.driver.findElement(By.xpath("//*[@id='command-navigation']/input[1]")).click();
    }
}
