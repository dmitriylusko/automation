package pages;


import helpers.BrowserActions;
import helpers.WrappedElement;
import org.openqa.selenium.By;

import static helpers.WebDriverSingleton.getInstance;


public class MainPage extends BasePage {

    private WrappedElement button;
    private BrowserActions browser;



    public MainPage (){
        button = new WrappedElement(button_locator, getInstance());
        browser = new BrowserActions();
    }

    public boolean isPageOpened (){
       return super.isPageOpened(button, MainPage.class);
    }



    private By button_locator = By.xpath("//div[@class='n-passport-suggest-popup-opener']");


    public void clickEnterToSiteButton (){
        button.click();
        browser.switchWindowHandle(1);
    }
}
