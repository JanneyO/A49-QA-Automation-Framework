import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {
//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
        //JanneyTest
    }
     @Test
     public void loginValidEmailPassword() {
         //WHEN I open my url
         navigateToPage();
         provideEmail();
         providePassword();
         clickSubmit();
         WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
         Assert.assertTrue(avatarIcon.isDisplayed());

     }

    public void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }

    public void providePassword() {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");
    }

    public void provideEmail() {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();
        emailField.sendKeys("demo@class.com");
    }

    public void navigateToPage() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }
}
