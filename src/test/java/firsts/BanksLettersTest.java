package firsts;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import utils.ConfigProperties;
import utils.model.User;
import utils.pages.BanksLetterPage;
import utils.pages.LoginPage;
import utils.pages.MainPage;
import utils.pages.NewPPPage;

import java.util.List;

import static utils.pages.Page.getDriver;

@Title("Сравнение 2х списков Сообщений для банка")
public class BanksLettersTest {
  final static Logger logger = Logger.getLogger(BanksLettersTest.class);


  @BeforeClass
  public void setUp() {
     getDriver().get(ConfigProperties.getTestProperty("url"));
  }



   @Test
   public void compareTwoListsBanksLettersTest() {
    User user1 = new User("1111111111", "1111111111");
    new LoginPage()
            .loginAs(user1);
    new MainPage().clickCreateNewPP();
    new NewPPPage().clickOnPageLetter();
    List<WebElement> webElements1 = new BanksLetterPage().createListBanksLetters();

//    String str = webElements1.stream().map(WebElement::getText).collect(Collectors.joining(";"));

    StringBuilder builder1 = new StringBuilder();
    for (WebElement element : webElements1) {
      builder1.append(element.getText()).append(";");
    }
    String str1 = builder1.toString();

    setUp();
    User user2 = new User("2222222222", "1111111111");
    new LoginPage()
            .loginAs(user2);
    new MainPage().clickCreateNewPP();
    new NewPPPage().clickOnPageLetter();
    List<WebElement> webElements2 = new BanksLetterPage().createListBanksLetters();
    StringBuilder builder2 = new StringBuilder();
    for (WebElement element : webElements2) {
      builder2.append(element.getText()).append(";");
    }
    String str2 = builder2.toString();


    if (str1.equals(str2)) {
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
