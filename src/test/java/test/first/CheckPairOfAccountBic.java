package test.first;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ConfigProperties;

public class CheckPairOfAccountBic extends TestBase {


  @Test

  public void clearAccountField() {

    String noaccont = "Не указан счет получателя, что допустимо только в случае, если получатель - кредитная организация.";

    goToMyPP();

    driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input")).click();
    driver.findElement(By.xpath("//div[@class='field__clean']/i")).click();
    driver.findElement(By.xpath("//div[@class='Button__labelClass--_0Dmv' and text()='Сохранить']")).click();

    WebElement warningAccount = driver.findElement(By.xpath("//div[@class=\"message\"]//div[@class='message__text']"));
    wait.until(ExpectedConditions.visibilityOf(warningAccount));
    warningAccount.click();
    warningAccount.getText();
    Assert.assertTrue("Сообщения при сохранении ПП без счета не совпадают", warningAccount.getText().equals(noaccont));

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
    String size = "11111.810.8.11111111111";

    goToMyPP();

    driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input")).click();
    driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input")).clear();
    driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input")).sendKeys(ConfigProperties.getTestProperty("account3"));
//    driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input")).sendKeys(ConfigProperties.getTestProperty("account2"));
//    driver.findElement(By.xpath("//div[@class='Button__labelClass--_0Dmv' and text()='Сохранить']")).click();

    WebElement account21 = driver.findElement(By.xpath("//div[@title='Расчетный счет получателя']/div[2]/input"));
    //wait.until(ExpectedConditions.visibilityOf(messageAccount));
    //messageAccount.click();
    String text = account21.getText();
    Assert.assertTrue("Счета не совпадают", text.length() == 23);


  }

}









