package vinoth;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class vinoth {
	WebDriver driver;
	@BeforeTest
	private void test() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.skytrans.com.au");
		driver.manage().window().maximize();
	}
	@Test
	private void test1() {
//		verify check box
	    WebElement checkbox = driver.findElement(By.id("chkRoundTrip"));
        checkbox.click();
        WebElement rdate = driver.findElement(By.xpath("(//label[text()='Return Date'])[1]"));
	    String text = rdate.getText();
	    Assert.assertEquals("verify checkbox","Return Date",text);
	
//	    verify countyname
	    
	    WebElement from = driver.findElement(By.id("lstOrigAP"));
	    Select s = new Select(from);
	     s.selectByIndex(3);
	    List<WebElement> all = s.getAllSelectedOptions();
	    WebElement webElement = all.get(0);
	    String text2 = webElement.getText();
	    Assert.assertEquals("Bamaga",text2);
	}
	  private void test2() {
//		driver.quit();

	}
}
