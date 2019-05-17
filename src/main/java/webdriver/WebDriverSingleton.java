package webdriver;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.Properties;


public class WebDriverSingleton {

    private static WebDriver driver;
    private static final String browserKind = "Chrome";
    private static FirefoxOptions firefoxOptions;
    private static FirefoxProfile firefoxProfile;
    private static ChromeOptions chromeOptions;
    //private static final Properties properties;

    private WebDriverSingleton (){}

    public static WebDriver getInstance () {
        if (driver != null) {
            return driver;
        }
        switch (browserKind) {
            case "Chrome":
                WebDriverManager.chromedriver().setup(); //Выбрать метод пропертис - добавить проперти на локализацию
                //WebDriverManager.chromedriver().properties("");//добавить из WebDriverManager.setExport для экспорта
                driver = new ChromeDriver();
                return driver;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                WebDriverManager.firefoxdriver().version("66.0.5");
                firefoxProfile = new FirefoxProfile();
                firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
                firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
                firefoxOptions = new FirefoxOptions();
                firefoxOptions.setProfile(firefoxProfile);
                driver = new FirefoxDriver(firefoxOptions);
                return driver;
            case "InternetExplorer":
                WebDriverManager.iedriver().setup();
               //WebDriverManager.iedriver().properties("");
                return driver;
            default:
                throw new IllegalStateException("Incorrect browser name. " +
                        "\nBrowser name should be: \"FIREFOX\", \"CHROME\" or \"INTERNET_EXPLORER\"");

        }
    }
}
