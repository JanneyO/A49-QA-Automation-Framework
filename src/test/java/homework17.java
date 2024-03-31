import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homework17 extends BaseTest{
    @Test
public void addSongToPlaylist() throws InterruptedException {

    String expectedSongAddedMessage = "Added 1 song to playlist\"Test Pro Playlist.\" ";
    navigateToPage();
    provideEmail("email");
    providePassword("password");
    clickSubmit();
    Thread.sleep(2000);
    searchSong();
    clickViewAllBtn();
    selectFirstSongResult();
    clickAddToBtn();
    choosePlaylist();
    Assert.assertTrue(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);
}

    public void searchSong(){
        WebElement searchbar = driver.findElement(By.cssSelector("input[type='search']"));
        searchbar.clear();
        searchbar.sendKeys("DarkDays");
        searchbar.click();
    }

    public void clickViewAllBtn(){
        WebElement ViewAllBtn = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        ViewAllBtn.click();
    }

    private void selectFirstSongResult(){
        WebElement firstSong = driver.findElement(By.cssSelector("input[class='song-list-header sortable]"));
        firstSong.click();
    }

    private void clickAddToBtn() {
        WebElement addToBtn = driver.findElement(By.cssSelector(".btn-add-to"));
        addToBtn.click();
    }

    private void choosePlaylist(){
        WebElement playlist = driver. findElement(By.cssSelector("[class='favorites']"));
    }

    private boolean getAddToPlaylistSuccessMsg()
    {
        return false;
    }
}


