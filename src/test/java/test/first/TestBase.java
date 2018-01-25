package test.first;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class TestBase {
  final static Logger logger = Logger.getLogger(BanksLetters.class);
  public WebDriver driver;
  public WebDriverWait wait;
  public Actions action;
  public DesiredCapabilities capabilities;
  /*public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();


  public boolean isElementPresent(final By locator) {
    try {
      wait.until((WebDriver d) -> d.findElement(locator));
      return true;
    } catch (TimeoutException ex) {
      return false;
    }
  }*/

  @Before
  public void start() {

    capabilities = new DesiredCapabilities();
    driver = new ChromeDriver(capabilities);

   /* ChromeOptions options = new ChromeOptions();
    options.addArguments("start-fullscreen"); // добавили аргумент start-fullscreen
    driver = new ChromeDriver(options);*/


    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // неявные ожидания
    wait = new WebDriverWait(driver, 10);

  }

  public void goToMyPP() {
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

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }
}

