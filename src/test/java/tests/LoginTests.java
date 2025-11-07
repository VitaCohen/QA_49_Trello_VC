package tests;

import dto.User;
import manager.AppManager;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.devtools.DevToolsException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends AppManager {

    @Test
    public void loginPositiveTest() {
        User user = User.builder()
                .email("vita.cohen.test49@gmail.com")
                .password("Password123456!")
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        Assert.assertTrue(new BoardsPage(getDriver()).validateUrl("boards"));

    }

    @Test(expectedExceptions = TimeoutException.class)
    public void loginNegativeTest() {
        User user = User.builder()
                .email("vita.cohen.test49@gmail.com")
                .password("Password123456!")
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        new BoardsPage(getDriver()).validateUrl("adsasb");


    }

    @Test
    public void loginNegativeTest_Another() {
        User user = User.builder()
                .email("vita.cohen.test49@gmail.com")
                .password("Password123456!")
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        Assert.assertFalse(new BoardsPage(getDriver()).validateUrlWOCreateException("hjhj"));


    }


}
