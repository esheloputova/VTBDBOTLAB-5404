package utils.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewPPPage extends Page {

  @FindBy(xpath = "//div[text()='Сообщение для банка']")
  private WebElement textBanksLetters;

  @FindBy(xpath = "//button[text()='Сообщение для Банка']")
  private WebElement buttonBanksLetters;

  public BanksLetterPage clickOnPageLetter() {
      textBanksLetters.click();
    buttonBanksLetters.click();
    return new BanksLetterPage();
  }


}
