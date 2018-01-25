package utils.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoToMyPaymentOrderPage extends Page {

  @FindBy(xpath = "//div[contains(@class,'table__row')]//div[text()='Elena']")
  private WebElement myPp;


  public void ppPageMy() {
    new WebDriverWait(getDriver(), 7).until(ExpectedConditions.visibilityOf(myPp));
    myPp.click();
    new Actions(driver).doubleClick(myPp).build().perform();



  }

}
