package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GamesOnSteamPage extends BasePage {

    private By pageHeaderName = By.xpath("//h2[@class='pageheader']");
    private BaseElement pageHeader;
    private final String headerTitle = "Games on Steam";


    public static class TabBar {
        private By topSelling_locator = By.xpath("//div[@id='tab_select_TopSellers']");
        private By gamesOnDiscount_locator = By.xpath("//div[@id='TopSellersRows']//following::div[@class='discount_block tab_item_discount']");
        private BaseElement topSelling, gamesOnDiscount;
        private final String topSellingAttribute = "class";
        private final String expectedAttributValue = "tab  tab_filler active";
        private LinkedList<WebElement> discountGames;
        private int maxDiscount, originaPrice, finalPrice;
        private WebElement elementWithMaxDiscount;
        private String regex = "-(\\d+)%$\\n\\Q$\\E(\\d+.\\d{1,2})\\n\\Q$\\E(\\d{1,3}.+)\\s";



        public TabBar (){
            topSelling = new Link(topSelling_locator);
            gamesOnDiscount = new Row(gamesOnDiscount_locator);
        }

        public void clickOnSellingTab(){
            topSelling.click();
        }

        public boolean isTabBarOpened (){
           if (topSelling.getAttribute(topSellingAttribute).equals(expectedAttributValue)){
               return true;
           }
           return false;
        }

        public void getGameWithHighestDiscount (){
            findElementWithMaxDiscount();
        }

        private void findElementWithMaxDiscount (){
            discountGames = new LinkedList<>();
            discountGames.addAll(gamesOnDiscount.findElements());
            discountGames.stream().forEach(game -> compareDiscounts(game));
            System.out.println("Max Discount: " + maxDiscount);
            System.out.println("Original Price: " + originaPrice);
            System.out.println("Final Price: " + finalPrice);

        }


        //TODO ПРОВЕРИТЬ ГДЕ ОШИБКА
        //TODO ЕСЛИ НЕ НАШЕЛ ТО ПОПРОБОВАТЬ ПРОСКРОЛЛИТЬ ДО КОНЦА СТРАНИЦЫ И СНОВА ЗАПУСТИТЬ
        //TODO ЕСЛИ НЕТ - ЗАБРАТЬ РЕГУЛЯРКОЙ ЧЕРЕЗ ПЭЙДЖСОУРС
        private void compareDiscounts (WebElement game){
            String discountStringValue = game.getText();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(discountStringValue);
            int counter = 0;
            while (matcher.find()){
                System.out.println(matcher.group(1));
               if (++counter == 1){
                   maxDiscount = Integer.parseInt(matcher.group(1));
               }
               compare(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
            }
           //int gameDiscount = Integer.parseInt(discountStringValue);
           //System.out.println(gameDiscount);
           ////if (gameDiscount > maxDiscount){
//
           ////}
           //return gameDiscount;
        }

        private void compare (int discount, int originaPrice, int finalPrice){
            if (discount < maxDiscount){
                maxDiscount = discount;
                this.originaPrice = originaPrice;
                this.finalPrice = finalPrice;
            }
        }




    }





    public GamesOnSteamPage (){
        pageHeader = new Text(pageHeaderName);
    }

    @Override
    public boolean isPageOpened() {
        if (pageHeader.isDisplayed() && pageHeader.getText().contains(headerTitle)){
            return true;
        }
        return false;
    }

    //TODO
    @Override
    public void openPage() {
    }
}
