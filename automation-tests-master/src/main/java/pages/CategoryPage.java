package pages;

import helpers.WrappedElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.WebDriverSingleton.getInstance;

public class CategoryPage extends UserAccountPage{

    private WrappedElement selectedCategory, logoutButton;
    private WebDriver driver;

    public CategoryPage (){
        driver = getInstance();
        selectedCategory = new WrappedElement(selectedCategory_locator, driver);
        logoutButton = new WrappedElement(logOut_locator, driver);
        isPageOpened(selectedCategory, CategoryPage.class);
    }

    @Override
    public boolean isPageOpened (){
        return super.isPageOpened(selectedCategory, CategoryPage.class);
    }

    private By selectedCategory_locator = By.cssSelector("[data-reactroot] > h1");
    private By logOut_locator = By.cssSelector("ul.header2-user-menu__list:nth-last-child(1) > li:last-child");

    public WebElement getSelectedCategory (){
        return selectedCategory.findElement();
    }

    public void logOut () {
        userIcon.click();
        logoutButton.click();
    }
}
