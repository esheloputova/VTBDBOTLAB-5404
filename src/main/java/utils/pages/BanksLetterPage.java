package utils.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BanksLetterPage extends Page {

  @FindBy(xpath = "//div[text()='Сообщение для банка']")
  private WebElement textBanksLetters;

  @FindBy(xpath = "//button[text()='Сообщение для Банка']")
  private WebElement buttonBanksLetters;

  @FindBy(xpath = "//span[text()='Все']")
  private WebElement showAllElementsOfBanksLetters;

  @FindBys(@FindBy(xpath = "//div[@class='table__row']"))
  private List<WebElement> allElementsOfBanksLetters;

  public List<WebElement> createListBanksLetters() {
    new MainPage().clickCreateNewPP();
    textBanksLetters.click();
    buttonBanksLetters.click();
    new WebDriverWait(getDriver(), 7).until(ExpectedConditions.visibilityOf(showAllElementsOfBanksLetters));
    showAllElementsOfBanksLetters.click();
    new WebDriverWait(getDriver(), 7).until(ExpectedConditions.visibilityOfAllElements(allElementsOfBanksLetters));

    return new ArrayList<>(allElementsOfBanksLetters);
  }


}
