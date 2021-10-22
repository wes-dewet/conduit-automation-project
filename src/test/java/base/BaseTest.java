package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pages.*;


public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;

    /* setUp method to create an instance of the WebDriver
     ** Launches the Conduit web application
     **/
    @BeforeClass
    @Parameters({"Browser"})
    public void setUp(String browser){
        if(browser.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.get("http://13.245.237.41:8080/");

        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}