package org.vinith;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Skytrans1 {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 driver =new ChromeDriver();
		driver.get("https://www.skytrans.com.au/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
		WebElement depart = driver.findElement(By.name("DepartureAirportCode"));
		Select s = new Select(depart);
		s.selectByIndex(2);
		WebElement arriv = driver.findElement(By.name("ArrivalAirportCode"));
		Select v = new Select(arriv);
		v.selectByValue("KUG");
		WebElement dep = driver.findElement(By.id("departure"));
		dep.click();
		WebElement sd = driver.findElement(By.xpath("(//a[@class='ui-state-default'])[9]"));
		sd.click();
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        Set<String> secwin = driver.getWindowHandles();
        List<String> ct = new LinkedList<>();
        ct.addAll(secwin);
        driver.switchTo().window(ct.get(1));
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        driver.findElement(By.xpath("//button[text()='Select']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()=' Continue ']")).click();  
        WebElement ttl = driver.findElement(By.id("title_0"));
        
        Select j = new Select(ttl);
        j.selectByIndex(1);
        
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Vinith");
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("Vini");
        driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("Chennai");
        driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("Chennai");
        driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("Chennai");
        driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys("600117");
        
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("vinith@gmail.com");
        driver.findElement(By.xpath("(//input[@type='tel'])[1]")).sendKeys("7856315869");
        driver.findElement(By.xpath("(//input[@type='tel'])[2]")).sendKeys("78563789");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	}
//	WebElement chk = driver.findElement(By.id("chkRoundTrip"));
//	chk.click();
//	WebElement ariv = driver.findElement(By.id("arrival"));
//	ariv.click();
//	WebElement ad = driver.findElement(By.xpath("(//a[@class='ui-state-default'])[9]"));
//	ad.click();
	
//  WebElement cntry = driver.findElement(By.xpath("//select[@class='form-control dropdown-toggle ng-pristine ng-valid ng-touched']"));
//  Select s1 = new Select(cntry);
//  s1.selectByVisibleText("India");
//  WebElement pro = driver.findElement(By.xpath("//select[@id='province_picker_281653b0-a192-4cc4-be51-715700df417c']"));
//  Select s2 = new Select(pro);
//  s2.selectByIndex(1);


}
