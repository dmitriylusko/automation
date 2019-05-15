package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.regex.Matcher;

public class WrappedElement {

    private By locator;
    private WebDriver driver;
    private Waiters waiters;
    private WebElement element;

    public WrappedElement(By locator, WebDriver driver){
        this.locator = locator;
        this.driver = driver;
        waiters = new Waiters();
    }



    public  WebElement findElement (){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements (){
        return driver.findElements(locator);
    }

    public void click (){
        waiters.waitUntilClickable(5,100, locator);
        findElement().click();
    }

    public void sendKeys(String keyToSend){
        findElement().sendKeys(keyToSend);
    }

    public void submitAfterTypingText (String text){
        element = findElement();
        if (waiters.waitForSubmitUntilFieldsIsNotFill(element, text)){
            element.submit();
        }
    }

    public String getAttribute (String attribute){
        return findElement().getAttribute(attribute);
    }

    public boolean isEnabled (){
        return driver.findElement(locator).isEnabled();
    }
}
