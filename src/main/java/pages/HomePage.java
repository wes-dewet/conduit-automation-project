package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By signInLink = By.cssSelector("nav > div > ul > li:nth-child(2) > a");

    //instantiating the driver that has already been launched
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //returning a handle to the Sign In Page
    public SignInPage clickSignInLink(){
        driver.findElement(signInLink).click();
        return new SignInPage(driver);
    }
}
