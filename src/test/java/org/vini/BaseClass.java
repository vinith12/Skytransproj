package org.vini;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver brwsrlnch() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	public static void url(String s) {
		driver.get(s);
	}
//	public static void navigate(String a) {
//       driver.navigate().to(a);;
//	}

	public static void maxi() {
		driver.manage().window().maximize();
	}

	public static void waite() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static String crnturl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public static void sndkeys(WebElement a, String b) {
		a.sendKeys(b);
	}

	public static void clik(WebElement cl) {
		cl.click();
	}

	public static String gettext(WebElement x) {
		String tt = x.getText();
		return tt;
	}

	public static String getatt(WebElement x) {
		String atr = x.getAttribute("value");
		return atr;
	}

	public static void drgdrp(WebElement a, WebElement b) {
		Actions c = new Actions(driver);
		c.dragAndDrop(a, b).perform();
		c.build().perform();
		c.doubleClick().perform();
		c.click().perform();
		c.contextClick();
		c.moveToElement(a);
	}

	public static void alert() {
      Alert v = driver.switchTo().alert();
      v.accept();
	}
	public static void alert2() {
	      Alert d = driver.switchTo().alert();
	      d.dismiss();
	}
	public static void selebyind(WebElement x, int v) {
		Select s = new Select(x);
		s.selectByIndex(v);
	}

	public static void selebyval(WebElement x, String a) {
		Select s = new Select(x);
		s.selectByValue(a);
	}
	
	public static void selebyvisitext(WebElement x, String a) {
		Select s = new Select(x);
		s.selectByVisibleText(a);
	}
	
	public static void frames(Integer x) {
     driver.switchTo().frame(x);
	}
	public static void windowhandle(Integer a) {
     Set<String> wh = driver.getWindowHandles();
      
     List<String> l = new LinkedList<String>();
     l.addAll(wh);
     driver.switchTo().window(l.get(a));
	}
//	public static void table(WebElement a, String b) {
//      a.
//	}
			
	public static String excel(String filename,int row, int cell) throws IOException  {

		File f =new File("C:\\Users\\DELL\\eclipse-workspace\\MavenFrameWrk\\src\\test\\resources\\Excel\\"+filename+".xlsx");
		
		FileInputStream fi = new FileInputStream(f);
		
		Workbook w =new XSSFWorkbook(fi);
		
		Sheet s = w.getSheet("Sheet1");
		
		Row r = s.getRow(row);
		
		Cell cel = r.getCell(cell);

		int ty = cel.getCellType();
		
		String value=null;
		if (ty==1) {
			 value = cel.getStringCellValue();
		}
		else {
			if(DateUtil.isCellDateFormatted(cel)) {
				Date dcv = cel.getDateCellValue();
				SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
				 value = sf.format(dcv);
			}
			else {
				double ncv = cel.getNumericCellValue();
				long num =(long)ncv;
				  value = String.valueOf(num);
				
			}
		}
		return value;		
		
	}

}
