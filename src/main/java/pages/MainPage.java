package pages;

import org.openqa.selenium.By;

public class MainPage extends BasePage {

    private final By installSteam_locator = By.xpath("//div[@id='global_action_menu']/div/a");
    private final BaseElement installSteamButton;
    private final String INSTALL_STEAM_TEXT = "Install Steam";

    public static class NavigationArea {
        private final By gamesDropDown_locator = By.xpath("//a[contains(text(),'Games')]");
        private BaseElement games;

        public NavigationArea (){
            games = new DropDown(gamesDropDown_locator);
        }

        public void selectGamesFromDropDown (){
            games.click();
        }
    }







    public MainPage (){
        installSteamButton = new Button(installSteam_locator);
    }

    public void clickInstallSteamButton(){
        installSteamButton.click();
    }

    @Override
    public boolean isPageOpened() {
        if (installSteamButton.isDisplayed()
                && installSteamButton.getText().equals(INSTALL_STEAM_TEXT)){
            return true;
        }
        return false;
    }

    //TODO добавить инициализацию из проперти файла
    @Override
    public void openPage() {
    }
}
