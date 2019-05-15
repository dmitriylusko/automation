package utils;

import helpers.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import pages.UserAccountPage;

import static helpers.WebDriverSingleton.*;

public class Regex extends UserAccountPage{

    private UserAccountPage page;
    private WebDriver driver;

    public Regex (){
        page = new UserAccountPage();
        driver = getInstance();
    }



}
