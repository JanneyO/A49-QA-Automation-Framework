package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.UUID;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
    }
    public void navigateToPage(String url) {
        driver.get(url);
    }
    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }


    void clickOnElement(By locator){
        WebElement el= wait.until(ExpectedConditions.elementToBeClickable(locator));
        el.click();
    }
    void enterText(By locator, String text){
        WebElement el= wait.until(ExpectedConditions.elementToBeClickable(locator));
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    void clickOnOk() {
        WebElement okBtn = driver.findElement(By.cssSelector(".ok"));
        okBtn.click();
    }
    public void checkShowSuccess() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        Assert.assertTrue(notification.isDisplayed());
    }
    public void quitBrowser(){
        driver.quit();
    }
}