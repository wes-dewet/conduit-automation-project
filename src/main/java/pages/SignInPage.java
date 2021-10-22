package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

    private WebDriver driver;
    private By emailField = By.cssSelector("fieldset:nth-child(1) > input");
    private By passwordField = By.cssSelector("fieldset:nth-child(2) > input");
    private By signInButton = By.cssSelector("form > button");
    private By loginErrorMessage = By.cssSelector("div > div > div > div > ul");

    public SignInPage(WebDriver driver){
        this.driver = driver;
    }

    public void setEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public boolean loginErrorMessageDisplayed(){
        return driver.findElement(loginErrorMessage).isDisplayed();
    }

    public LoggedInHomePage clickSignInButton(){
        driver.findElement(signInButton).click();
        return new LoggedInHomePage(driver);
    }
}
