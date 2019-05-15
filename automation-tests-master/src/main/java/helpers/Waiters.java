package helpers;


import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

import static helpers.WebDriverSingleton.*;

public class Waiters {

    private WebDriver driver;

    public Waiters (){

        this.driver = getInstance();
    }


    public void waitUntilClickable (int timeUnit, int pollingTime, By by){
        new WebDriverWait(driver, timeUnit, pollingTime).until(ExpectedConditions.elementToBeClickable(by));
    }

    public boolean waitForSubmitUntilFieldsIsNotFill (WebElement element, String fillStr) {
        return new WebDriverWait(driver, 10).until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return element.getAttribute("value").equals(fillStr);
            }
        });

    }
}
