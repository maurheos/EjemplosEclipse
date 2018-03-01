package pkgfinacletrade;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FinacleSophos {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    //driver = new FirefoxDriver();
	driver = new InternetExplorerDriver();
    driver.manage().window().maximize();
    baseUrl = "https://srvbd1.sophos.com:9999/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //driver.navigate().back();
    //driver.navigate().refresh();
    //driver.navigate().forward();
  }
  
  @Test
  public void testLogueoFinacle() throws Exception {
    driver.get(baseUrl + "SSO/ui/SSOLogin.jsp");
     
    //driver.findElement(By.id("usertxt")).clear();
    //Thread.sleep(10000);
    
    // Inspect element
	//WebElement username= driver.findElement(By.xpath("/html/body/div/table/tbody/tr[1]/td[2]/form/table/tbody/tr[1]/td[2]/input")); 
    WebElement username= driver.findElement(By.xpath("//frame[@name='loginFrame']"));
    // Call reuse method
	HighLightElement.highLightElement(driver,username);
    
    driver.findElement(By.xpath("//frame[@name='loginFrame']")).click();
    driver.findElement(By.xpath("//frame[@name='loginFrame']")).sendKeys("MHENAO");
    driver.findElement(By.xpath("//INPUT[@id='passtxt']")).click();
    driver.findElement(By.xpath("//INPUT[@id='passtxt']")).sendKeys("Sophos.2018");
    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement element= wait.until(ExpectedConditions.elementToBeClickable(By.id("usertxt")));
    element.sendKeys("Usuario");
    //String sRow = "2";
    //String sCol = "2";
    //driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/article/div/table/tbody/tr["+sRow+"]/td["+sCol+"]")).getText();
    //driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/form/table/tbody/tr["+sRow+"]/td["+sCol+"]")).sendKeys("MHENAO");
    
    driver.findElement(By.xpath("//*[@id='usertxt']/html/body/div/table/tbody/tr/td[2]/form/table/tbody/tr/td[2]/input")).sendKeys("MHENAO");
    Thread.sleep(3000);
		driver.findElement(By.xpath("//TEXT[@id='usertxt']")).clear();
    driver.findElement(By.id("usertxt")).sendKeys("MHENAO");
    driver.findElement(By.id("passtxt")).clear();
    driver.findElement(By.id("passtxt")).sendKeys("Sophos.2018");
    driver.findElement(By.id("Submit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=loginFrame | ]]
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//*[@id='DeskTop']/table[2]/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[12]/td[2]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    new Select(driver.findElement(By.id("appSelect"))).selectByVisibleText("FINCORE");
    // ERROR: Caught exception [unknown command []]
    driver.findElement(By.cssSelector("img[alt=\"Logout\"]")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to logout[\\s\\S]$"));
    driver.findElement(By.name("Submit2")).click();
    driver.findElement(By.id("CLACM_anc")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=FINW | ]]
    driver.findElement(By.cssSelector("#sLnk2 > img")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=Search_AccountIdCriteria | ]]
    driver.findElement(By.id("Submit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=Search_AccountIdResults | ]]
    driver.findElement(By.id("0")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=FINW | ]]
    driver.findElement(By.id("Submit")).click();
    assertEquals(closeAlertAndGetItsText(), "Field Must be entered.");
    driver.findElement(By.id("lnAcctId")).clear();
    driver.findElement(By.id("lnAcctId")).sendKeys("");
    driver.findElement(By.id("anc_hdrm")).click();
    new Select(driver.findElement(By.id("mpIntent"))).selectByVisibleText("Note");
    driver.findElement(By.cssSelector("#sLnk4 > img.img")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=Search_AccountIdCriteria | ]]
    driver.findElement(By.id("Submit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=Search_AccountIdResults | ]]
    driver.findElement(By.id("0")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=FINW | ]]
    driver.findElement(By.cssSelector("#sLnk6 > img.img")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    driver.findElement(By.cssSelector("#anc_nxtm > img[name=\"previousYear\"]")).click();
    driver.findElement(By.id("but30")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | loginFrame | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | CoreServer | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | FINW | ]]
    driver.findElement(By.id("Accept")).click();
    driver.findElement(By.id("Back")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=loginFrame | ]]
    driver.findElement(By.cssSelector("img[alt=\"Logout\"]")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to logout[\\s\\S]$"));
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=loginFrame | ]]
    new Select(driver.findElement(By.id("appSelect"))).selectByVisibleText("FINCORE");
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
