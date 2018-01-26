package utils.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.model.Account;
import utils.model.Bic;

public class EditPaymentOrderPage extends Page {

  String noaccount = "Не указан счет получателя, что допустимо только в случае, если получатель - кредитная организация.";
  String sucSaved = "Документ успешно сохранен";
  String messageForAccount = "Ключ счета получателя неверен. Должен быть 1";
  String messageAboutLengthAccount = "Длина значения поля счет получателя должна быть 20 символов";


  @FindBy(xpath = "//div[@title='Расчетный счет получателя']/div[2]/input")
  private WebElement accountOFrecipient;

  @FindBy(xpath = "//div[@class='field__clean']/i")
  private WebElement accountCleaning;

  @FindBy(xpath = "//div[text()='Сохранить']")
  private WebElement saveButton;

  @FindBy(xpath = "//div[@class='message']//div[@class='message__text']")
  private WebElement warningAccount;

  @FindBy(xpath = "//div[@title='БИК']/div[2]/div[1]/input")
  private WebElement bicBankOfrecipient;

  @FindBy(xpath = "//div[@class='PushItem__text--14a_h' and text()='Документ успешно сохранен']")
  private WebElement successfulSaved;

  @FindBy(xpath = "//div[@title='Расчетный счет получателя']//div[@class='field__tooltip field__tooltip_error']")
  private WebElement messageAccount;

  @FindBy(xpath = "//div[@class=\"field__tooltip field__tooltip_error\"]")
  private WebElement account19;


  public void clearAccountField() {
    new WebDriverWait(getDriver(), 7).until(ExpectedConditions.visibilityOf(accountOFrecipient));
    accountOFrecipient.click();
    accountCleaning.click();
    saveButton.click();
    new WebDriverWait(getDriver(), 7).until(ExpectedConditions.visibilityOf(warningAccount));
    warningAccount.click();
    Assert.assertTrue("Сообщения при сохранении ПП без счета не совпадают", warningAccount.getText().equals(noaccount));
  }

  public void successfulSave(Account account, Bic bic) {
    new WebDriverWait(getDriver(), 7).until(ExpectedConditions.visibilityOf(accountOFrecipient));
    accountOFrecipient.click();
    accountCleaning.click();
    accountOFrecipient.sendKeys(account.getAccount());
    bicBankOfrecipient.click();
    bicBankOfrecipient.clear();
    bicBankOfrecipient.sendKeys(bic.getBic());
    saveButton.click();
    new WebDriverWait(getDriver(), 7).until(ExpectedConditions.visibilityOf(successfulSaved));
    successfulSaved.click();
    Assert.assertTrue("Сообщения не совпадают", successfulSaved.getText().equals(sucSaved));
  }

  public void incorrectPairsAccountBic(Account account) {
    new WebDriverWait(getDriver(), 7).until(ExpectedConditions.visibilityOf(accountOFrecipient));
    accountOFrecipient.click();
    accountCleaning.click();
    accountOFrecipient.sendKeys(account.getAccount());
    saveButton.click();
    new WebDriverWait(getDriver(), 7).until(ExpectedConditions.visibilityOf(accountOFrecipient));
    messageAccount.click();
    Assert.assertTrue("Пара счет и БИК некорректны", messageAccount.getText().equals(messageForAccount));
  }

  public void enterAccountMorePossible(Account account) {
    new WebDriverWait(getDriver(), 7).until(ExpectedConditions.visibilityOf(accountOFrecipient));
    accountOFrecipient.click();
    accountCleaning.click();
    accountOFrecipient.sendKeys(account.getAccount());
    String fieldAccount = accountOFrecipient.getAttribute("defaultValue");
    Assert.assertTrue("Длина счета не 20 символов", fieldAccount.length() == 23);
  }

  public void enterAccountLessPossible(Account account) {
    new WebDriverWait(getDriver(), 7).until(ExpectedConditions.visibilityOf(accountOFrecipient));
    accountOFrecipient.click();
    accountCleaning.click();
    accountOFrecipient.sendKeys(account.getAccount());
    saveButton.click();
    String textError = account19.getText();
    Assert.assertTrue("Длина счета меньше 20 символов", textError.equals(messageAboutLengthAccount));
  }

  public void enterLettersInAccount(Account account) {
    new WebDriverWait(getDriver(), 7).until(ExpectedConditions.visibilityOf(accountOFrecipient));
    accountOFrecipient.click();
    accountCleaning.click();
    accountOFrecipient.sendKeys(account.getAccount());
    String fieldAccountLetters = accountOFrecipient.getAttribute("defaultValue");
    Assert.assertTrue("В поле счет можно ввести буквы", fieldAccountLetters.length() == 0);
  }

  public void enterCharactersInAccount(Account account) {
    new WebDriverWait(getDriver(), 7).until(ExpectedConditions.visibilityOf(accountOFrecipient));
    accountOFrecipient.click();
    accountCleaning.click();
    accountOFrecipient.sendKeys(account.getAccount());
    String fieldAccountLetters = accountOFrecipient.getAttribute("defaultValue");
    Assert.assertTrue("В поле счет можно ввести спецсимволы", fieldAccountLetters.length() == 0);
  }


}
