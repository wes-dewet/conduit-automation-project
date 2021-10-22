package conduit;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ArticleDisplayPage;
import pages.LoggedInHomePage;
import pages.SignInPage;
import pages.NewArticleEditorPage;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateNewArticleTests extends BaseTest{
    @Test
    public void testCreateNewArticle() throws InterruptedException{
        SignInPage signInPage = homePage.clickSignInLink();
        signInPage.setEmailField("brucewayne@yopmail.com");
        signInPage.setPasswordField("password1");
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        //signed in and moved to LoggedInHomePage
        LoggedInHomePage loggedInHomePage = signInPage.clickSignInButton();
        Thread.sleep(5000);

        NewArticleEditorPage newArticleEditorPage = loggedInHomePage.clickNewArticleLink();
        Thread.sleep(5000);
        newArticleEditorPage.setTitleField("Why so serious??? " + timeStamp);
        newArticleEditorPage.setDescriptionField("Something the joker said to me");
        newArticleEditorPage.setBodyField("Something I will never forget");
        newArticleEditorPage.setTagsField("clown");

        ArticleDisplayPage newArticleDisplayPage = newArticleEditorPage.clickPublishArticleButton();
        Thread.sleep(5000);
        assertTrue(newArticleDisplayPage.editButtonExists(), "Edit button not visible");
        assertEquals(newArticleDisplayPage.getEditArticleButtonText(),
                " Edit Article", "Edit article button not present");
    }

    @Test
    public void testTitle() throws InterruptedException{
        SignInPage signInPage = homePage.clickSignInLink();
        signInPage.setEmailField("brucewayne@yopmail.com");
        signInPage.setPasswordField("password1");

        //signed in and moved to LoggedInHomePage
        LoggedInHomePage loggedInHomePage = signInPage.clickSignInButton();
        Thread.sleep(5000);

        NewArticleEditorPage newArticleEditorPage = loggedInHomePage.clickNewArticleLink();
        Thread.sleep(5000);

        newArticleEditorPage.setTitleField("A symbol of hope");
        ArticleDisplayPage newArticleDisplayPage = newArticleEditorPage.clickPublishArticleButton();
        Thread.sleep(5000);
        assertTrue(newArticleDisplayPage.editButtonExists(), "Edit button not visible");
    }
}
