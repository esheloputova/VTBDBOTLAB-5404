package test.first;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BanksLetters extends TestBase {

  @Test
  public void banksLettersTheFirstUser() {
    User user = new User(driver);
    user.login("1111111111", "1111111111");
    //goToMyPP();
    driver.findElement(By.xpath("//div[text()='Создать ПП']")).click();
    driver.findElement(By.xpath("//div[text()='Сообщение для банка']")).click();
    driver.findElement(By.xpath("//button[text()='Сообщение для Банка']")).click();
    driver.findElement(By.xpath("//span[text()='Все']")).click();

    List<WebElement> user1 = driver.findElements(By.xpath("//div[@class='table__row']"));
    wait.until(ExpectedConditions.visibilityOfAllElements(user1));


    user.login("2222222222", "1111111111");
    //goToMyPP();
    driver.findElement(By.xpath("//div[text()='Создать ПП']")).click();

    driver.findElement(By.xpath("//div[text()='Сообщение для банка']")).click();
    driver.findElement(By.xpath("//button[text()='Сообщение для Банка']")).click();
    driver.findElement(By.xpath("//span[text()='Все']")).click();

    List<WebElement> user2 = driver.findElements(By.xpath("//div[@class='table__row']"));
    wait.until(ExpectedConditions.visibilityOfAllElements(user2));
    driver.quit();

    if (user2.equals(user1)) {
      logger.info("Списки равны");
    } else {
      logger.info("Списки не равны");
    }
  }

}





