package net.commments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Test22 {

    private final WebDriver[] driver = new WebDriver[1];

    @Test
    public void test() {
        this.driver().get("http://commentssprintone.azurewebsites.net");
        this.driver().findElements(By.id("newbutton")).get(0).click();
        WebElement text = this.driver().findElement(By.id("Text"));
        String symbols = "@#$%^&*&*";
        text.sendKeys(symbols);
        this.driver().findElements(By.xpath("//*[@id=\"editor-navigation\"]/input[1]")).get(0).click();
        String errorText = this.driver().findElement(By.id("errorfield")).getText();
        assertEquals(errorText, "The Comment Text field should contain alphanumeric characters only");
    }

    @BeforeMethod
    public void createDriver() {
        driver[0] = new ChromeDriver();
    }

    @AfterMethod
    public void closeDriver() {
        driver[0].quit();
    }

    private WebDriver driver() {
        return this.driver[0];
    }
}
