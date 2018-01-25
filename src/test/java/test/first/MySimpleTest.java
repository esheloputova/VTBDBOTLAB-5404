package test.first;

import org.junit.Before;
import org.junit.Test;
import utils.ConfigProperties;
import utils.model.User;
import utils.pages.LoginPage;

import static utils.pages.Page.getDriver;

public class MySimpleTest {


    @Before
    public void setUp(){
        getDriver().get(ConfigProperties.getTestProperty("url"));
    }
    @Test
    public void loginTest(){
        User user = new User("1111111111","1111111111");
        new LoginPage()
                .loginAs(user)
                .clickCreateNewPP();
    }
}
