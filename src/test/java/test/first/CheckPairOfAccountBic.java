package test.first;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ConfigProperties;

public class CheckPairOfAccountBic extends TestBase {


  @Test

  public void clearAccountField() {

    String noaccount = "Не указан счет получателя, что допустимо только в случае, если получатель - кредитная организация.";

    goToMyPP();

    driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input")).click();
    driver.findElement(By.xpath("//div[@class='field__clean']/i")).click();
    driver.findElement(By.xpath("//div[text()='Сохранить']")).click();

    WebElement warningAccount = driver.findElement(By.xpath("//div[@class=\"message\"]//div[@class='message__text']"));
    wait.until(ExpectedConditions.visibilityOf(warningAccount));
    warningAccount.click();
    warningAccount.getText();
    Assert.assertTrue("Сообщения при сохранении ПП без счета не совпадают", warningAccount.getText().equals(noaccount));

  }

  @Test
  public void successfulSave() {

    String sucSaved = "Документ успешно сохранен";

    goToMyPP();

    driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input")).click();
    driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input")).clear();
    driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input")).sendKeys(ConfigProperties.getTestProperty("account1"));
    driver.findElement(By.xpath("//div[@title='БИК']/div[2]/div[1]/input")).click();
    driver.findElement(By.xpath("//div[@title='БИК']/div[2]/div[1]/input")).clear();
    driver.findElement(By.xpath("//div[@title='БИК']/div[2]/div[1]/input")).sendKeys(ConfigProperties.getTestProperty("bic1"));
    driver.findElement(By.xpath("//div[@class='Button__labelClass--_0Dmv' and text()='Сохранить']")).click();

    WebElement successfulSaved = driver.findElement(By.xpath("//div[@class='PushItem__text--14a_h' and text()='Документ успешно сохранен']"));
    wait.until(ExpectedConditions.visibilityOf(successfulSaved));
    successfulSaved.click();
    successfulSaved.getText();
    Assert.assertTrue("Сообщения не совпадают", successfulSaved.getText().equals(sucSaved));

  }


  @Test
  public void incorrectPairsAccountBic() {

    String messageForAccount = "Ключ счета получателя неверен. Должен быть 1";

    goToMyPP();

    driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input")).click();
    driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input")).clear();
    driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input")).sendKeys(ConfigProperties.getTestProperty("account2"));
    driver.findElement(By.xpath("//div[@class='Button__labelClass--_0Dmv' and text()='Сохранить']")).click();

    WebElement messageAccount = driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']//div[@class='field__tooltip field__tooltip_error']"));
    wait.until(ExpectedConditions.visibilityOf(messageAccount));
    messageAccount.click();
    messageAccount.getText();
    Assert.assertTrue("Сообщения при сохранении ПП без счета не совпадают", messageAccount.getText().equals(messageForAccount));

  }

  @Test
  public void enterAccountMorePossible() {

    goToMyPP();

    driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input")).click();
    driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input")).clear();
    driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input")).sendKeys(ConfigProperties.getTestProperty("account3"));

    WebElement account21 = driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input"));
    String fieldAccount = account21.getAttribute("defaultValue");
    Assert.assertTrue("Длина счета не 20 символов", fieldAccount.length() == 23);
  }

  @Test
  public void enterAccountLesPossible() {

    String messageAboutLengthAccount = "Длина значения поля счет получателя должна быть 20 символов";

    goToMyPP();
    driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input")).click();
    driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input")).clear();
    driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input")).sendKeys(ConfigProperties.getTestProperty("account4"));
    driver.findElement(By.xpath("//div[@class='Button__labelClass--_0Dmv' and text()='Сохранить']")).click();

    WebElement account19 = driver.findElement(By.xpath("//div[@class=\"field__tooltip field__tooltip_error\"]"));
    String textError = account19.getText();
    Assert.assertTrue("Длина счета меньше 20 символов", textError.equals(messageAboutLengthAccount));

  }

  @Test
  public void enterLettersInAccount() {
    goToMyPP();
    driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input")).click();
    driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input")).clear();
    driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input")).sendKeys(ConfigProperties.getTestProperty("account5"));

    WebElement account0 = driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input"));
    String fieldAccountLetters = account0.getAttribute("defaultValue");
    Assert.assertTrue("В поле счет можно ввести буквы", fieldAccountLetters.length() == 0);

  }

  @Test
  public void enterCharactersInAccount() {
    goToMyPP();
    driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input")).click();
    driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input")).clear();
    driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input")).sendKeys(ConfigProperties.getTestProperty("account6"));

    WebElement accountCharacters = driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input"));
    String fieldAccountChar = accountCharacters.getAttribute("defaultValue");
    Assert.assertTrue("В поле счет можно ввести спецсимволы", fieldAccountChar.length() == 0);

  }
}











