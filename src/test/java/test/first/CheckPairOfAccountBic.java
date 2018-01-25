package test.first;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.ConfigProperties;
import utils.model.User;
import utils.pages.EditMyPaymentOrder;
import utils.pages.LoginPage;
import utils.pages.GoToMyPaymentOrderPage;

import static utils.pages.Page.getDriver;

public class CheckPairOfAccountBic {


  @Before
  public void setUp() {
    getDriver().get(ConfigProperties.getTestProperty("url"));
  }

  @Test
  public void clearAccountFieldTest() {
    User user = new User("1111111111", "1111111111");
    new LoginPage()
            .loginAs(user)
            //.clickCreateNewPP();
            .clickPP();
    new GoToMyPaymentOrderPage()
            .ppPageMy();
    new EditMyPaymentOrder()
            .clearAccountField();
      }

  @After
  public void stop() {
    getDriver().quit();

  }
}
