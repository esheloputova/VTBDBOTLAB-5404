package utils.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page{

    @FindBy(xpath = "")
    private WebElement createNewPP;

    public void clickCreateNewPP(){
        createNewPP.click();
    }
}
