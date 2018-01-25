package test.first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class GoToMePP {

  public WebDriver driver;

  public GoToMePP(WebDriver driver) {
    this.driver = driver;
  }

  public WebDriverWait wait;

  public GoToMePP(WebDriverWait wait) {
    this.wait = wait;
  }

}

/*  public void goToMyPP() {
    driver.findElement(By.linkText("Расчеты в рублях")).click();
    wait.until(visibilityOfElementLocated(By.linkText("Расчеты в рублях")));
    driver.findElement(By.linkText("Расчеты в рублях")).click();

    WebElement mypp = driver.findElement(By.xpath("//div[contains(@class,'table__row')]//div[text()=\"Elena\"]"));
    wait.until(ExpectedConditions.elementToBeClickable(mypp));
    mypp.click();
    mypp = driver.findElement(By.xpath("//div[contains(@class,'table__row')]//div[text()=\"Elena\"]"));

    action = new Actions(driver);
    action.doubleClick(mypp).build().perform();
  }
}*/
