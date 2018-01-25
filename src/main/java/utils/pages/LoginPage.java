package utils.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.model.User;

public class LoginPage extends Page{

    @FindBy(xpath = "//input[@type='text']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Войти']")
    private WebElement submitButton;

    public MainPage loginAs(User user){
        loginField.click();
        loginField.clear();
        loginField.sendKeys(user.getLogin());

        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(user.getPassword());

        submitButton.click();

        return new MainPage();

    }


}
