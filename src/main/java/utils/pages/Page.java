package utils.pages;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import static java.lang.System.setProperty;
import static jdk.nashorn.internal.objects.NativeString.toLowerCase;

public abstract class Page {
  protected static WebDriver driver;
  protected WebDriverWait wait;
  protected Actions action;


  public Page() {

    PageFactory.initElements(getDriver(), this);

  }


  public static WebDriver getDriver() {
    if (driver == null) {
      //  System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//      driver = new ChromeDriver();

//      DesiredCapabilities capability = DesiredCapabilities.chrome();
//      capability.setBrowserName("chrome");
//      capability.setPlatform(Platform.WIN10);
//      URL hostURL = null;
//      try {
//        hostURL = new URL(" http://192.168.1.42:5555/wd/hub");
//      } catch (MalformedURLException e) {
//        e.printStackTrace();
//      }
//      driver = new RemoteWebDriver(hostURL, capability);
//    }

      DesiredCapabilities caps = new DesiredCapabilities();
      Properties property = new Properties();
      property.setProperty("browser", toLowerCase(setProperty("browser", System.getProperty("browser"))));
      if ((property.getProperty("browser").equals("firefox") || property.getProperty("browser").equals("chrome")) || property.getProperty("browser").equals("internet explorer")||property.getProperty("browser").equals("chrome"))
      caps.setBrowserName(property.getProperty("browser"));
      //else caps.setBrowserName("chrome");

      URL hostURL = null;
      try {
        hostURL = new URL(" http://192.168.1.42:5555/wd/hub");
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
      driver = new RemoteWebDriver(hostURL, caps);
    }

    return driver;


  }
}