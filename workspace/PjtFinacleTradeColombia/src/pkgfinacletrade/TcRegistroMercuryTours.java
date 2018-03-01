package pkgfinacletrade;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TcRegistroMercuryTours {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://newtours.demoaut.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTcRegistro() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("REGISTER")).click();
    driver.findElement(By.name("firstName")).clear();
    driver.findElement(By.name("firstName")).sendKeys("Traveler");
    driver.findElement(By.name("lastName")).clear();
    driver.findElement(By.name("lastName")).sendKeys("Sophos");
    driver.findElement(By.name("phone")).clear();
    driver.findElement(By.name("phone")).sendKeys("3000000");
    driver.findElement(By.id("userName")).clear();
    driver.findElement(By.id("userName")).sendKeys("travelersophos@correo.com");
    driver.findElement(By.name("address1")).clear();
    driver.findElement(By.name("address1")).sendKeys("Cr 54 # 12 11");
    driver.findElement(By.name("address2")).clear();
    driver.findElement(By.name("address2")).sendKeys("Ofc. 751");
    driver.findElement(By.name("city")).clear();
    driver.findElement(By.name("city")).sendKeys("Medellin");
    driver.findElement(By.name("state")).clear();
    driver.findElement(By.name("state")).sendKeys("Antioquia");
    driver.findElement(By.name("postalCode")).clear();
    driver.findElement(By.name("postalCode")).sendKeys("000000");
    new Select(driver.findElement(By.name("country"))).selectByVisibleText("COLOMBIA");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("travelerSophos");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("Sophos.2018");
    driver.findElement(By.name("confirmPassword")).clear();
    driver.findElement(By.name("confirmPassword")).sendKeys("Sophos.2018");
    driver.findElement(By.name("register")).click();
    driver.findElement(By.linkText("Home")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
