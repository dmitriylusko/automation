package pages;

import org.openqa.selenium.By;

public class WelcomeToSteamPage extends BasePage {

    private By learnMore_locator = By.xpath("//div[@class='learn_more_btn']");
    private By installSteamNow_locator = By.xpath("//div[@class='about_install mac ']/a");
    private BaseElement learnMoreLink, installSteamNowButton;

    public WelcomeToSteamPage (){
        learnMoreLink = new Link(learnMore_locator);
        installSteamNowButton = new Button(installSteamNow_locator);
    }





    public void clickInstallSteamNow (){
        installSteamNowButton.click();
    }

    @Override
    public boolean isPageOpened() {
        if (learnMoreLink.isDisplayed()){
            return true;
        }
        return false;
    }

    //TODO добавить инициализацию из проперти файла
    @Override
    public void openPage() {
    }
}
