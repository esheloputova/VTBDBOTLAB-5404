package utils.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

    protected static WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;

    public Page() {

        PageFactory.initElements(getDriver(),  this);
       // PageFactory.initElements(getAction(),this);

    }


    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

  /*  public WebDriverWait justWait() {
        //if (wait == null) {
            wait = new WebDriverWait(driver, 10);
        //}
        return wait;
    }

    public Actions doubleAction() {
        //if (action == null) {
            action = new Actions(driver);
        //}
        return action;

    }*/
}