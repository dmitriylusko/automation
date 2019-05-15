package pages;

import exceptions.IncorrectPageOpenException;
import helpers.BrowserActions;
import helpers.WebDriverSingleton;
import helpers.WrappedElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BasePage {



    public boolean isPageOpened (WrappedElement elementForCheck, Class someclass){
            if (!elementForCheck.isEnabled()){
                throw new IncorrectPageOpenException("No element: " + elementForCheck.toString()
                        + " on " + someclass.getName() + " page!");
            }
            return true;
    }



}
