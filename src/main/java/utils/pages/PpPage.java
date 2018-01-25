package utils.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PpPage extends Page {

  @FindBy(linkText = "Расчеты в рублях")
  private WebElement ppPage;

  @FindBy(xpath = "//div[contains(@class,'table__row')]//div[text()='Elena']")
  private WebElement myPp;


  public void ppPageAs() {
    ppPage.click();
    wait.until(ExpectedConditions.visibilityOf(ppPage));
    ppPage.click();
    action.doubleClick(myPp).build().perform();

  }

}
