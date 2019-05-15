package pages;

import helpers.BrowserActions;
import helpers.WebDriverSingleton;
import helpers.WrappedElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

import static helpers.WebDriverSingleton.*;


public class UserAccountPage extends BasePage{


    protected WebElement randomCategory;
    protected WebDriver driver;
    protected LinkedList<WebElement> popularCategories;
    protected WrappedElement categories, userIcon;


    public UserAccountPage () {
        driver = getInstance();
        popularCategories = new LinkedList<>();
        categories = new WrappedElement(allPopularCategories_locator, driver);
        userIcon = new WrappedElement(userIcon_locator, driver);isPageOpened(userIcon, UserAccountPage.class);
    }


    protected By allPopularCategories_locator = By.xpath("//div[@class='n-w-tab n-w-tab_type_navigation-menu']/a");
    protected By userIcon_locator = By.cssSelector("div.n-passport-suggest-popup-opener > a");

    public void scrollDown (){

    }


    public boolean isPageOpened (){
        return super.isPageOpened(userIcon, UserAccountPage.class);
    }

    public List<WebElement> getAllCategories () {
        return categories.findElements();
    }

    public List<WebElement> getPopularCategoriesFromList (List <WebElement> allCategories){
        allCategories.stream().filter(webElement -> webElement.isDisplayed())
                .forEach(popularCategories::add);
        return popularCategories;
    }

    public void chooseRandomCategory(List<WebElement> popularCategories) {
        int n = (int) (Math.random() * popularCategories.size());
        randomCategory = popularCategories.get(n);
        randomCategory.click();
    }

    public WebElement getRandomCategory (){
        if (!(randomCategory == null)){
            return randomCategory;
        }
        throw new IllegalStateException("Random category element is null!");
    }

}
