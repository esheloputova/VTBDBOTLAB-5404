package firsts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;
import utils.ConfigProperties;
import utils.model.Account;
import utils.model.Bic;
import utils.model.User;
import utils.pages.EditPaymentOrderPage;
import utils.pages.LoginPage;
import utils.pages.PaymentOrdersInRoublesPage;

import static utils.pages.Page.getDriver;

@Title("Разные проверки поля Счет")
public class CheckPairOfAccountBicTest {
  //public WebDriver driver;

 // @Parameters({"browserName", "browserVersion"})
  @BeforeClass
  public void setUp() {
     getDriver().get(ConfigProperties.getTestProperty("url"));

  }


    @Title("Сохранение ПП без счета")
    @Test
      public void clearAccountFieldTest() {
    User user = new User("1111111111", "1111111111");
    new LoginPage()
            .loginAs(user)
            .clickPP();
    new PaymentOrdersInRoublesPage()
            .ppPageMy();
    new EditPaymentOrderPage()
            .clearAccountField();

  }

  @Title("Cохранение ПП с корректным набором счет + бик")
  @Test
  public void successfulSaveTest() {
    User user = new User("1111111111", "1111111111");
    Account account = new Account("11111810811111111111");
    Bic bic = new Bic("040037470");
    new LoginPage()
            .loginAs(user)
            .clickPP();
    new PaymentOrdersInRoublesPage()
            .ppPageMy();
    new EditPaymentOrderPage()
            .successfulSave(account, bic);
  }

  @Title("Cохранение ПП с корректным набором счет + бик")
  @Test
  public void incorrectPairsAccountBicTest() {
    User user = new User("1111111111", "1111111111");
    Account account = new Account("11111810811111111112");
    Bic bic = new Bic("040037470");
    new LoginPage()
            .loginAs(user)
            .clickPP();
    new PaymentOrdersInRoublesPage()
            .ppPageMy();
    new EditPaymentOrderPage()
            .incorrectPairsAccountBic(account);
  }

  @Title("Вводим в поле счет больше 20 символов")
  @Test
  public void enterAccountMorePossibleTest() {
    User user = new User("1111111111", "1111111111");
    Account account = new Account("111118108111111111113");
    new LoginPage()
            .loginAs(user)
            .clickPP();
    new PaymentOrdersInRoublesPage()
            .ppPageMy();
    new EditPaymentOrderPage()
            .enterAccountMorePossible(account);
  }

  @Title("Вводим в поле счет буквы")
  @Test
  public void enterAccountLesPossibleTest() {
    User user = new User("1111111111", "1111111111");
    Account account = new Account("1111181081111111110");
    new LoginPage()
            .loginAs(user)
            .clickPP();
    new PaymentOrdersInRoublesPage()
            .ppPageMy();
    new EditPaymentOrderPage()
            .enterAccountLessPossible(account);
  }

  @Title("Вводим в поле счет меньше 20 символов")
  @Test
  public void enterLettersInAccountTest() {
    User user = new User("1111111111", "1111111111");
    Account account = new Account("testЭтоТест");
    new LoginPage()
            .loginAs(user)
            .clickPP();
    new PaymentOrdersInRoublesPage()
            .ppPageMy();
    new EditPaymentOrderPage()
            .enterLettersInAccount(account);
  }

  @Title("Вводим в поле счет спецсимволы")
  @Test
  public void enterCharactersInAccountTest() {
    User user = new User("1111111111", "1111111111");
    Account account = new Account("!@#$%^&*()_");
    new LoginPage()
            .loginAs(user)
            .clickPP();
    new PaymentOrdersInRoublesPage()
            .ppPageMy();
    new EditPaymentOrderPage()
            .enterCharactersInAccount(account);
  }


  @AfterClass
  public void updatePage() {
    getDriver().navigate().refresh();
  }

//  @AfterSuite
//  public static void stop() {
//    getDriver().quit();
//  }
}







