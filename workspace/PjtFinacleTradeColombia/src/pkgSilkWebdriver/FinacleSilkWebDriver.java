package pkgSilkWebdriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.support.ui.Select;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;

//import org.openqa.jetty.html.Select;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FinacleSilkWebDriver {

	private WebDriver driver;

	@Before
	public void setup() {
		//driver = new FirefoxDriver();
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void myTestCaseName() {
		driver.get("https://srvbd1.sophos.com:9999/SSO/ui/SSOLogin.jsp");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.name("loginFrame")));
		driver.findElement(By.xpath("(//td)[2]")).click();
		driver.findElement(By.id("usertxt")).sendKeys("MHENAO");
		driver.findElement(By.id("passtxt")).sendKeys("Fina.2018");
		driver.findElement(By.id("Submit")).click();
		//driver.findElement(By.id("appSelect")).sendKeys("FINCORE");
		//driver.switchTo().frame(driver.findElement(By.name("appletFrame")));
		Select oSelect = new Select(driver.findElement(By.name("appSelect")));
		oSelect.selectByIndex(3);
		// Switching to Alert
        Alert alert = driver.switchTo().alert();
        // Capturing alert message.
        String alertMessage = driver.switchTo().alert().getText();
        // Displaying alert message
        System.out.println(alertMessage);
        // Accepting alert
        alert.accept();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Select oSelectLeft = new Select(driver.findElement(By.xpath("//a[text()='Trade Finance Custom Menu']")));
		//oSelectLeft.selectByIndex(7);
        
		//driver.findElement(By.xpath("//a[text()='Trade Finance Custom Menu']")).click();
		//driver.findElement(By.xpath("//b[text()='Loan Pay Ahead Payments (CAPHM)']")).click();
        
        //WebElement oSelectMenu = driver.findElement(By.name("bgMenuUrl"));
        //oSelectMenu.sendKeys("HLAOPI");
        driver.switchTo().activeElement();
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td/table/tbody/tr/td[2]/table/tbody/tr/td[3]/input[1]")).sendKeys("HLAOPI");
        
        driver.findElement(By.name("menuName")).sendKeys("HLAOPI");
        driver.findElement(By.name("menuName")).sendKeys("gotomenul");
		//new Select(driver.findElement(By.name("appSelect"))).selectByValue("CoreServer");
		//driver.switchTo().parentFrame();
		driver.switchTo().activeElement();
		driver.findElement(By.id("TFMNO_anc")).click();

		
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//new Select(driver.findElement(By.id("appSelect"))).selectByVisibleText("FINCORE");
		//driver.findElement(By.xpath("//img[@alt=\"Change Credentials\"]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//img[@alt=\"Logout\"]")).click();
		//driver.switchTo().parentFrame();
	}

	@After
	public void tearDown() {
		if (driver != null) {
			//driver.quit();
		}
	}

}