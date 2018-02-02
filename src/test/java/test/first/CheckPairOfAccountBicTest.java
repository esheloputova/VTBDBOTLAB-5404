package test.first;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import utils.ConfigProperties;
import utils.model.Account;
import utils.model.Bic;
import utils.model.User;
import utils.pages.EditPaymentOrderPage;
import utils.pages.LoginPage;
import utils.pages.PaymentOrdersInRoublesPage;

import static utils.pages.Page.getDriver;

public class CheckPairOfAccountBicTest {


  @Before
  public void setUp() {
    getDriver().get(ConfigProperties.getTestProperty("url"));
  }

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
  public static void stop() {
    getDriver().quit();
  }


}




