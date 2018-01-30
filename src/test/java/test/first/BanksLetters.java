package test.first;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import utils.ConfigProperties;
import utils.model.User;
import utils.pages.BanksLetterPage;
import utils.pages.LoginPage;

import java.util.List;

import static utils.pages.Page.getDriver;

public class BanksLetters {
  final static Logger logger = Logger.getLogger(BanksLetters.class);

  @Before
  public void setUp() {
    getDriver().get(ConfigProperties.getTestProperty("url"));
  }

  @Test
  public void compareTwoListsBanksLettersTest() {
    User user1 = new User("1111111111", "1111111111");
    new LoginPage()
            .loginAs(user1);
    List<WebElement> webElements1 = new BanksLetterPage().createListBanksLetters();
    String webElements11 = webElements1.toString();


    setUp();
    User user2 = new User("2222222222", "1111111111");
    new LoginPage()
            .loginAs(user2);
    List<WebElement> webElements2 = new BanksLetterPage().createListBanksLetters();
    String webElements22 = webElements2.toString();


    if (webElements11.equals(webElements22)) {
      logger.info("Списки равны!");
    } else {
      logger.info("Списки не равны!");
    }
  }

  @AfterClass
  public static void stop() {
    getDriver().quit();
  }


}
