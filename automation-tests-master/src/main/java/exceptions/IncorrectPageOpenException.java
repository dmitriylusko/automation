package exceptions;

import org.openqa.selenium.WebDriverException;

public class IncorrectPageOpenException extends WebDriverException {

    public IncorrectPageOpenException(String message){
        super(message);
    }
}
