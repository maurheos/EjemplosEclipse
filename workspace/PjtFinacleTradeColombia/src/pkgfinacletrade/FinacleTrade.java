package pkgfinacletrade;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FinacleTrade {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
	//DesiredCapabilities caps = DesiredCapabilities.internetExplorer();  
	//caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);    
	//driver = new InternetExplorerDriver(caps);
	//System.setProperty("webdriver.ie.driver", "IEDriverServer32.exe"); 
	//File file = new File("F:/IEDriverServer32.exe");
	//System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
	//WebDriver driver = new InternetExplorerDriver();
	//System.setProperty("webdriver.ie.driver","F:\\IEDriverServer.exe");
	//DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
	//dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);  //If IE fail to work, please remove this and remove enable protected mode for all the 4 zones from Internet options
	//WebDriver driver = new InternetExplorerDriver();
	//driver = new InternetExplorerDriver();
	//baseUrl = "https://pbmdebqfin11.bancolombia.corp:9999";
	baseUrl = "https://srvbd1.sophos.com:9999";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testFinacleTrade() throws Exception {
    driver.get(baseUrl + "/SSO/ui/SSOLogin.jsp");
    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Thread.sleep(3000);
    //assertEquals(driver.getTitle(), "Finacle Universal Banking Solution");
    //assertTrue(isElementPresent(By.id("usertxt")));
    //assertTrue(isElementPresent(By.xpath("//input[@id='usertxt']")));
    //driver.findElement(By.xpath("//input[@id='usertxt']"));  
    //assertTrue(isElementPresent(By.xpath("//input[@name='usertxt']")));
    //driver.findElement(By.xpath("//input[@name='usertxt']"));
    //driver.findElement(By.cssSelector("input[id='usertxt']")).sendKeys("JAARESTR" + Keys.ENTER);
      
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | loginFrame | ]]
    //driver.findElement(By.id("usertxt")).clear();
    driver.findElement(By.id("usertxt")).sendKeys("JAARESTR" + Keys.ENTER);
    driver.findElement(By.id("passtxt")).clear();
    driver.findElement(By.id("passtxt")).sendKeys("Banko2016*");
    driver.findElement(By.id("Submit")).click();
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
