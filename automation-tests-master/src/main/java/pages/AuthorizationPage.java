package pages;

import helpers.BrowserActions;
import helpers.Waiters;
import helpers.WebDriverSingleton;
import helpers.WrappedElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static helpers.Waiters.*;
import static helpers.WebDriverSingleton.*;

public class AuthorizationPage extends BasePage{

    private WebDriver driver;
    private WrappedElement login, password;
    private BrowserActions browser;


    public AuthorizationPage (){
        this.driver = getInstance();
        browser = new BrowserActions();
        login = new WrappedElement(login_locator, driver);
        password = new WrappedElement(password_locator, driver);
        isPageOpened(login, AuthorizationPage.class);
    }



    private By login_locator = By.cssSelector("#passp-field-login");
    private By password_locator = By.cssSelector("#passp-field-passwd");


    public boolean isPageOpened (){
        return super.isPageOpened(login, AuthorizationPage.class);
    }

    public void setLogin (String user_login){
        login.sendKeys(user_login);
        login.submitAfterTypingText(user_login);
    }



    public void setPassword (String user_password){
        new Actions(driver)
                .click(password.findElement()).perform();
        password.sendKeys(user_password);
        password.submitAfterTypingText(user_password);
        browser.switchWindowHandle(-1);
    }


}
