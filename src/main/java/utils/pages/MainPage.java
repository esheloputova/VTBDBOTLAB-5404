package utils.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Page {

  @FindBy(xpath = "//div[text()='Создать ПП']")
  private WebElement createNewPP;

  @FindBy(linkText = "Расчеты в рублях")
  private WebElement ppPage;

  public void clickCreateNewPP() {
    new WebDriverWait(getDriver(), 7).until(ExpectedConditions.visibilityOf(createNewPP));
    createNewPP.click();
  }

  public  PaymentOrderPage clickPP() {
    new WebDriverWait(getDriver(),7).until(ExpectedConditions.visibilityOf(ppPage));
    ppPage.click();
    return new PaymentOrderPage();
  }
}
