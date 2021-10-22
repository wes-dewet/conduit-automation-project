package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedInHomePage {

    private WebDriver driver;
    private By newArticleLink = By.cssSelector("nav>div>ul>li:nth-child(2)>a");
    private By usernameLink = By.cssSelector("li:nth-child(4)>a");
    private By yourFeedLink = By.cssSelector("div.feed-toggle>ul>li:nth-child(1)>a");

    public LoggedInHomePage(WebDriver driver){
        this.driver = driver;
    }

    public String getYourFeedLinkText(){
        return driver.findElement(yourFeedLink).getText();
    }

    public String getUsernameLinkText(){
        return driver.findElement(usernameLink).getText();
    }

    public NewArticleEditorPage clickNewArticleLink(){
        driver.findElement(newArticleLink).click();
        return new NewArticleEditorPage(driver);
    }
}
