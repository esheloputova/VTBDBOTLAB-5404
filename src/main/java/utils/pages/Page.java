package utils.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {

    protected static WebDriver driver;

    public Page() {
        PageFactory.initElements(getDriver(), this);
    }

    public static WebDriver getDriver() {
        if (driver ==null){
            driver = new ChromeDriver();
        }
        return driver;
    }
}
