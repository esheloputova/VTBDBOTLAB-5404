package utils.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentOrdersInRoublesPage extends Page {
  @FindBy(xpath = "//div[contains(@id, 'root')]//div[text()='Платежные поручения']")
  private WebElement scrollerPP;

  @FindBy(xpath = "//div[contains(@class,'table__row')]//div[text()='Elena']")
  private WebElement myPaymentOrder;

  public EditPaymentOrderPage ppPageMy() {
    new WebDriverWait(getDriver(), 7).until(ExpectedConditions.visibilityOf(myPaymentOrder));
    myPaymentOrder.click();
    new Actions(driver).doubleClick(myPaymentOrder).build().perform();
    return new EditPaymentOrderPage();
  }

}


