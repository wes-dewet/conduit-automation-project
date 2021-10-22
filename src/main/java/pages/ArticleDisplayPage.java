package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArticleDisplayPage {

    private WebDriver driver;
    private By editArticleButton = By.cssSelector("div.banner > div > div > span > a > span");

    public ArticleDisplayPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean editButtonExists(){
        return driver.findElement(editArticleButton).isDisplayed();
    }
    public String getEditArticleButtonText(){
        return driver.findElement(editArticleButton).getText();
    }
}
