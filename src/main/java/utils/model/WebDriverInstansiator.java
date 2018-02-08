//package utils.model;
//
//import com.sun.javaws.BrowserSupportFactory;
//import org.openqa.grid.web.servlet.handler.WebDriverRequestFactory;
//import org.openqa.selenium.WebDriver;
//
//public class WebDriverInstansiator {
//  private static InheritableThreadLocal<WebDriver> webDriver = new InheritableThreadLocal<WebDriver>();
//  private static WebDriverRequestFactory factory;
//
//  public static void setDriver(String browserName, String browserVersion){
//    factory = new WebDriverRequestFactory();
//    webDriver.set(factory.(browserName, browserVersion));
//  }
//
//  public static WebDriver getDriver(){
//    return webDriver.get();
//  }
//}
