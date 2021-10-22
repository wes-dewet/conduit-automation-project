package conduit;

import base.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoggedInHomePage;
import pages.SignInPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest{
    @Test
    public void testSuccessfulLogin() throws InterruptedException{
        //start on HomePage then click sign in link and move to SignInPage
        SignInPage signInPage = homePage.clickSignInLink();
        signInPage.setEmailField("brucewayne@yopmail.com");
        signInPage.setPasswordField("password1");

        //signed in and moved to LoggedInHomePage
        LoggedInHomePage loggedInHomePage = signInPage.clickSignInButton();
        Thread.sleep(5000);
        assertEquals(loggedInHomePage.getYourFeedLinkText(), "Your Feed", "No feed button");
        assertEquals(loggedInHomePage.getUsernameLinkText(), "bwayne", "No username displayed");
        System.out.println("Woohoo you are logged in!");
    }

    @Test
    public void testUnsuccessfulLogin() throws InterruptedException{
        //start on HomePage then click sign in link and move to SignInPage
        SignInPage signInPage = homePage.clickSignInLink();
        signInPage.setEmailField("admin@coza");
        signInPage.setPasswordField("admincoza");

        //signed in and moved to LoggedInHomePage
        LoggedInHomePage loggedInHomePage = signInPage.clickSignInButton();
        Thread.sleep(5000);
        //any unsuccessful  login needs to display an error message to the user
        assertTrue(signInPage.loginErrorMessageDisplayed(),"No error message displayed");
    }
}