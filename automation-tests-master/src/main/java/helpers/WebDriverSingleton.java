package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverSingleton {

    private static WebDriver driver;
    private static String kind = "FIREFOX";


    private WebDriverSingleton (){}



    public static WebDriver getInstance () {
        if (driver != null) {
            return driver;
        }
        switch (kind) {
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                return driver;
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                return driver;
            case "INTERNET_EXPLORER":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                return driver;
            default:
                throw new IllegalStateException("Incorrect browser name. " +
                        "\nBrowser name should be: \"FIREFOX\", \"CHROME\" or \"INTERNET_EXPLORER\"");
        }
    }
}
