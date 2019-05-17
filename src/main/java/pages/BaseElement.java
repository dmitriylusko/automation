package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webdriver.WebDriverSingleton;

import java.util.List;

public abstract class BaseElement {

    private WebDriver driver;
    private By locator;

    public BaseElement (By locator){
        driver = WebDriverSingleton.getInstance();
        this.locator = locator;
    }

    protected WebElement findElement(){
        return driver.findElement(locator);
    }

    protected List<WebElement> findElements(){
        return driver.findElements(locator);
    }

    protected void click (){
        findElement().click();
    }

    protected boolean isDisplayed(){
        return findElement().isDisplayed();
    }

    protected String getText(){
        return findElement().getText();
    }

    protected String getAttribute (String attributeName){
        return findElement().getAttribute(attributeName);
    }


}
