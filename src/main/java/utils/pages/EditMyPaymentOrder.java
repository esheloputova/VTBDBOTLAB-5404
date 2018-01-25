package utils.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditMyPaymentOrder extends Page{

  String noaccount = "Не указан счет получателя, что допустимо только в случае, если получатель - кредитная организация.";

  @FindBy (xpath = "//div[@title='Расчетный счет получателя']/div[2]/input")
  private WebElement accountOFrecipient;

  @FindBy (xpath = "//div[@class='field__clean']/i")
  private WebElement accountCleaning;

  @FindBy (xpath = "//div[text()='Сохранить']")
  private WebElement saveButton;

  @FindBy (xpath = "//div[@class='message']//div[@class='message__text']")
  private WebElement warningAccount;

 public void clearAccountField(){
   new WebDriverWait(getDriver(), 7).until(ExpectedConditions.visibilityOf(accountOFrecipient));
   accountOFrecipient.click();
   accountCleaning.click();
   saveButton.click();

   new WebDriverWait(getDriver(), 7).until(ExpectedConditions.visibilityOf(warningAccount));
   warningAccount.click();
   warningAccount.getText();
   Assert.assertTrue("Сообщения при сохранении ПП без счета не совпадают", warningAccount.getText().equals(noaccount));
   //new WebDriverWait()wait.until(ExpectedConditions.visibilityOf(warningAccount));

 }


}
