import helpers.BrowserActions;
import helpers.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AuthorizationPage;
import pages.CategoryPage;
import pages.MainPage;
import pages.UserAccountPage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestClass {

    private String login = "TestUserSelenium", password = "12345test";



    private String regex = "6d2c096b=\"true\">(\\W.+?)<";





    private MainPage mainPage;
    private AuthorizationPage authorizationPage;
    private UserAccountPage userAccountPage;
    private CategoryPage categoryPage;
    private WebDriver driver;
    private BrowserActions browser;
    private String browsername = "FIREFOX", url = "https://market.yandex.ru", title = "Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов";


    @BeforeMethod
    public void initializaion (){
        browser = new BrowserActions();
        browser.deleteAllCookies();
        browser.setImplicitlyWaitInSeconds(10);
        browser.setPageLoadTimeOutInSeconds(10);
        browser.setFullScreen();
        browser.navigateToUrl(url);
    }


    @AfterMethod
    public void tearDown () {
        browser.deleteAllCookies();
        browser.quit();
        browser = null;
    }


    //TODO Сделать ассерт-месседжи каждого шага
    @Test
    public void test () throws InterruptedException {
        //Step 1 (Зайти на страницу https://market.yandex.ru)
        mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened());
        mainPage.clickEnterToSiteButton();



        //Step 2 (Выполнить процесс авторизации)
        authorizationPage = new AuthorizationPage();
        Assert.assertTrue(authorizationPage.isPageOpened());
        authorizationPage.setLogin(login);
        authorizationPage.setPassword(password);



        //Step 3 (Получить список популярных категорий)
        userAccountPage = new UserAccountPage();
        List<WebElement> allCategories = userAccountPage.getAllCategories();

        //Step 4 (Перейти на случайную категорию из списка)
        List<WebElement> popularCategories = userAccountPage.getPopularCategoriesFromList(allCategories);
        userAccountPage.chooseRandomCategory(popularCategories);
        categoryPage = new CategoryPage();
        Assert.assertTrue(categoryPage.isPageOpened());
        WebElement firstElement = userAccountPage.getRandomCategory();
        WebElement secondElement = categoryPage.getSelectedCategory();
        browser.moveBack();

        categoryPage.logOut();


    }
}
