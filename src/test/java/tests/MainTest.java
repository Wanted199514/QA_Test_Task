package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class MainTest extends BaseTest {
    String email = "your_email@gmail.com";
    String emailPassword = "your_password";
    String confirmPassword = "1q2w3e4r5t";

    @Test
    public void mainTest() {
        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Client login page is not loaded.");
        loginPage.login("paula47@example.com","123456");
        MainPage mainPage = loginPage.clickOnSignInButton();
        Assert.assertTrue(mainPage.mainPageIsLoaded(),"Client main Page is not loaded.");
        OwnersPage ownersPage = mainPage.clickOnOwnersPage();
        CreatePage createPage = ownersPage.clickOnCreateButton();
        Assert.assertTrue(createPage.createPageIsLoaded(),"Create Page is not loaded.");
        createPage.inputValidData("Jack","Wyski",email);
        Assert.assertEquals(createPage.alertIsLoaded(),"Element created","System notification is not correct.");
        GmailPage gmailPage = createPage.openGmailPage();
        Assert.assertTrue(gmailPage.gmailPageIsLoaded(),"Gmail Page is not loaded.");
        gmailPage.login(email,emailPassword);
        Assert.assertTrue(gmailPage.mikeMikeMailIsLoaded(),"Mike Mike message is missing.");
        gmailPage.goToURL();
        ChoosePasswordPage choosePasswordPage = gmailPage.changeTab();
        Assert.assertTrue(choosePasswordPage.choosePasswordPageIsLoaded(),"Choose password page is not loaded.");
        OwnersLoginPage ownersLoginPage = choosePasswordPage.createPassword(confirmPassword,confirmPassword);
        Assert.assertEquals(ownersLoginPage.alertIsLoaded(),"You have successfully set your password","System notification is not correct.");
        Assert.assertTrue(ownersLoginPage.ownersLoginPageIsLoaded(),"Owners login page is not loaded.");
        ownersLoginPage.login(email,confirmPassword);
        OwnersMainPage ownersMainPage = ownersLoginPage.clickOnSignInButton();
        Assert.assertTrue(ownersMainPage.ownersMainPageIsLoaded(),"Owners main page is not loaded.");

    }
}
