package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitUtils;

public class LoginPage extends BasePage {
    WaitUtils waitUtils = new WaitUtils(driver);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(className = "btn-login")
    private WebElement loginButton;

    public void enterUsername(String username){
        waitUtils.waitForVisibility(usernameField, username);
    }

    public void enterPassword(String password){
        waitUtils.waitForVisibility(passwordField, password);
    }

}
