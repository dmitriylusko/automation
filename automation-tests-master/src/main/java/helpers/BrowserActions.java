package helpers;

import exceptions.IncorrectSwitchWindowHandleDirection;
import org.openqa.selenium.WebDriver;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class BrowserActions {

    private WebDriver driver;
    private String nextWindow, previousWindow;
    private ArrayDeque<String> windowHandles = new ArrayDeque<>();

    public BrowserActions (){
        driver = WebDriverSingleton.getInstance();
    }


    public void setImplicitlyWaitInSeconds (int timeUnit){
        driver.manage().timeouts().implicitlyWait(timeUnit, TimeUnit.SECONDS);
    }

    public void setPageLoadTimeOutInSeconds (int timeUnit){
        driver.manage().timeouts().pageLoadTimeout(timeUnit, TimeUnit.SECONDS);
    }

    public void setFullScreen (){
        driver.manage().window().fullscreen();
    }

    public void navigateToUrl (String url){
        driver.get(url);
    }

    public void deleteAllCookies (){
        driver.manage().deleteAllCookies();
    }

    public void quit (){
        driver.quit();
    }

    public void switchWindowHandle (int direction) {
        windowHandles.addAll(driver.getWindowHandles());
        switch (direction){
            case -1:
                previousWindow = windowHandles.peekFirst();
                driver.switchTo().window(previousWindow);
                break;
            case 1:
                nextWindow = windowHandles.peekLast();
                driver.switchTo().window(nextWindow);
                break;
                default:
                    throw new IncorrectSwitchWindowHandleDirection("Wrong window handle direction! Use '1' - for switch to next, '-1' - for switch to previous");
        }
        windowHandles.clear();
    }

    public void moveBack (){
        driver.navigate().back();
    }



}
