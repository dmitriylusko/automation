import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GamesOnSteamPage;
import pages.MainPage;
import pages.WelcomeToSteamPage;
import utils.FileDownloadChecker;
import webdriver.WebDriverSingleton;

import java.util.concurrent.TimeUnit;

public class TestClass {



    private WebDriver driver;
    private FileDownloadChecker dowloadChecker;
    private WelcomeToSteamPage welcomePage;
    private GamesOnSteamPage gamesOnSteamPage; private GamesOnSteamPage.TabBar tabBar;
    private MainPage mainPage; private MainPage.NavigationArea navigationArea;


    @BeforeMethod
    public void initialization (){
        driver = WebDriverSingleton.getInstance();
        driver.get("https://store.steampowered.com/");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown (){
        driver.quit();
        driver = null;
    }


    //TODO добавить метод на открытие страницы в класс мэйнПэйдж
    //TODO добавить более подробные смс в ассертаъ
    @Test(description = "TC-1. Steam app download")
    public void steamAppDownload(){
        //Step 1: Open http://store.steampowered.com/
        //Expected Result: Steam store main page is opened
        mainPage = new MainPage();
        mainPage.openPage();
        Assert.assertTrue(mainPage.isPageOpened(), mainPage.getClass().getName() + " error! Wrong Page!");

        //Step 2: Click “Install Steam” button
        //Expected Result: “Welcome to Steam” page is opened
        mainPage.clickInstallSteamButton();
        welcomePage = new WelcomeToSteamPage();
        Assert.assertTrue(welcomePage.isPageOpened(), welcomePage.getClass().getName() + " error! Wrong Page!");


        //Step 3: Click “Install Steam Now” button -> download steam app
        //Expected Result: Steam app setup file is downloaded
        welcomePage.clickInstallSteamNow();
        dowloadChecker = new FileDownloadChecker();
        Assert.assertTrue(dowloadChecker.isFileHasBeenDownloaded(), dowloadChecker.getClass().getName() + " error! File in not download!");
    }


    @Test(description = "TC-2. Special calculation check")
    public void specialCalculationCheck (){
        //Step 1: Open http://store.steampowered.com/
        //Expected Result: Steam store main page is opened
        mainPage = new MainPage();
        mainPage.openPage();
        Assert.assertTrue(mainPage.isPageOpened(), mainPage.getClass().getName() + " error! Wrong Page!");

        //Step 2: Select Games -> Action in the top menu
        //Expected Result: “Browsing Action” page is opened
        navigationArea = new MainPage.NavigationArea();
        navigationArea.selectGamesFromDropDown();

        //Step 3: Navigate to “Top Selling” tab
        //Expected Result: Top Selling tab is opened
        gamesOnSteamPage = new GamesOnSteamPage();
        gamesOnSteamPage.openPage();
        tabBar = new GamesOnSteamPage.TabBar();
        tabBar.clickOnSellingTab();
        Assert.assertTrue(tabBar.isTabBarOpened(), gamesOnSteamPage.getClass().getName() + " error! Wrong Page!");

        tabBar.getGameWithHighestDiscount();




    }
}
