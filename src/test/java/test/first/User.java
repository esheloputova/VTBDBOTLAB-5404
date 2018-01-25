package test.first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigProperties;

import java.util.concurrent.TimeUnit;

public class User {

  public WebDriver driver;

  public User(WebDriver driver) {
    this.driver=driver;
  }

  public void login(String login, String password) {
    driver.get(ConfigProperties.getTestProperty("url"));
    driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//input[@type='text']")).click();
    driver.findElement(By.xpath("//input[@type='text']")).clear();
    driver.findElement(By.xpath("//input[@type='text']")).sendKeys(login);
    driver.findElement(By.xpath("//input[@type='password']")).click();
    driver.findElement(By.xpath("//input[@type='password']")).clear();
    driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
    driver.findElement(By.xpath("//form[contains(@class,'LoginView__loginForm--10LxW')]//button[@type='submit' and text()='Войти']")).click();
    }
}
