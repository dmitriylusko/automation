package exceptions;

import org.openqa.selenium.WebDriverException;

public class IncorrectSwitchWindowHandleDirection extends WebDriverException {

    public IncorrectSwitchWindowHandleDirection (String message){
        super(message);
    }
}
