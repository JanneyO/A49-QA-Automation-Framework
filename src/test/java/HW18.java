import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW18 extends BaseTest{

    @Test
    public void playSong() throws InterruptedException {

        navigateToPage();
        provideEmail("email");
        providePassword("password");
        clickSubmit();
        Thread.sleep(2000);
        clickPlayNextSongBtn();
        clickPlayBtn();
    }

    private void clickPlayNextSongBtn(){
        WebElement nextSongBtn = driver.findElement(By.cssSelector("[data-test id='play-next-btn']"));
        nextSongBtn.click();
    }

    private void clickPlayBtn(){
        WebElement clickPlayBtn = driver.findElement(By.cssSelector("[title='Play or resume']"));
        clickPlayBtn.click();
    }

}



