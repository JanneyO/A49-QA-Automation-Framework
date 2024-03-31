import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    WebDriver driver = new ChromeDriver();

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    public void navigateToPage() {
        String url = "http://qa.koel.app/";
        driver.get(url);
    }

    public void provideEmail(String email) {
        WebElement provideEmail = driver.findElement(By.cssSelector("[type='email']"));
        provideEmail.clear();
        provideEmail.click();
        provideEmail("email");
    }

    public void providePassword(String password) {
        WebElement providePassword = driver.findElement(By.cssSelector("[type='password']"));
        providePassword.clear();
        providePassword.click();
        providePassword("password");
    }

    public void clickSubmit() {
        WebElement loginBtn = driver.findElement(By.cssSelector("[type='submit']"));
        loginBtn.click();
    }

    public void clickPlayNextSongBtn() {
        WebElement nextSongBtn = driver.findElement(By.cssSelector("[data-test id='play-next-btn']"));
        nextSongBtn.click();
    }

    public void clickPlayBtn() {
        WebElement clickPlayBtn = driver.findElement(By.cssSelector("[title='Play or resume']"));
        clickPlayBtn.click();

    }
    public void closeBrowser() {
        Assert.assertEquals(driver.getCurrentUrl(), "00");
        driver.quit();
    }
}