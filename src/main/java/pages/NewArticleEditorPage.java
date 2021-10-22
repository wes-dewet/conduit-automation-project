package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewArticleEditorPage {

    private WebDriver driver;
    private By titleField = By.cssSelector("fieldset:nth-child(1) > input");
    private By descriptionField = By.cssSelector("fieldset:nth-child(2) > input");
    private By bodyField = By.cssSelector("fieldset:nth-child(3) > textarea");
    private By tagsField = By.cssSelector("fieldset:nth-child(4) > input");
    private By publishArticleButton = By.cssSelector("form > button");

    public NewArticleEditorPage(WebDriver driver){
        this.driver = driver;
    }

    public void setTitleField(String title){
        driver.findElement(titleField).sendKeys(title);
    }

    public void setDescriptionField(String description){
        driver.findElement(descriptionField).sendKeys(description);
    }

    public void setBodyField(String body){
        driver.findElement(bodyField).sendKeys(body);
    }

    public void setTagsField(String tags){
        driver.findElement(tagsField).sendKeys(tags);
    }

    public ArticleDisplayPage clickPublishArticleButton(){
        driver.findElement(publishArticleButton).click();
        return new ArticleDisplayPage(driver);
    }
}
