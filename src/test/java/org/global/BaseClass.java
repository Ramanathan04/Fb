package org.global;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static WebDriver driver;
public static WebElement element;
public static Select s;
public static JavascriptExecutor js;
public static Actions a;
public static Robot r;

public static final String AUTOMATE_USERNAME = "ramanathan23";
public static final String AUTOMATE_ACCESS_KEY = "jqcXK7PuYQydgMc3USyx";
public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";


public static void launchStack() throws MalformedURLException {
	 DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("os_version", "8.1");
	    caps.setCapability("resolution", "1024x768");
	    caps.setCapability("browser", "Chrome");
	    caps.setCapability("browser_version", "latest");
	    caps.setCapability("os", "Windows");
	    WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
	    driver.get("https://www.facebook.com/");
}

public static void loadBrowser(){
	WebDriverManager.chromedriver().setup();
	
	 driver=new ChromeDriver();
	 
	 }
public static void implicitWait() {
	
	driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
}
public static void launchUrl(String url) {
	driver.get(url);
}
public static void clk(WebElement element ){
	element.click();
}
public static void max() {
	driver.manage().window().maximize();
}
public static void fill(WebElement element,String text) {
	element.sendKeys(text);
}
public static String readExcel(int rowNo,int cellNo) throws IOException {

	File f= new File("C:\\Users\\Ramanathan\\eclipse-workspace\\maven\\TestNg\\Excel\\demoqa.xlsx");

	//To read a particular File....We need FileInputStream class object
	FileInputStream fin = new FileInputStream(f);
	
	//Excelshet or Workbook
	Workbook w=new XSSFWorkbook(fin);
	
	//Excelsheet...getSheet
	Sheet s = w.getSheet("Sheet1");
	Row r = s.getRow(rowNo);
	Cell c = r.getCell(cellNo);
		    

	//Get cell type............................................
			int cellType = c.getCellType();
		    String value="";


			if(cellType==1) {
				value = c.getStringCellValue();
				
			}
			else if (DateUtil.isCellDateFormatted(c)){
				Date d = c.getDateCellValue();
				SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
				value = sim.format(d);
				
			 }
			else {
				double d= c.getNumericCellValue();
				long l=(long)d;
				 value = String.valueOf(l);
			
			}
			return value;
			
		}
	public static void scrollDown(WebElement element){
		js=(JavascriptExecutor)driver;

	 js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	public static void scrollUp(WebElement element) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	public static void jsSendKey(WebElement element,String text) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+text+"')", element);
	}
	
	public static String txtFromPage(WebElement element) {
		String text = element.getText();
		return text;
	}
	public static void click(WebElement element) {
		element.click();
	}
	public static void mouseHover(WebElement element) {
		 a=new Actions(driver);
		 a.moveToElement(element).perform();;
	}
	public static void dragandDrop(WebElement element1,WebElement element2) {
		a=new Actions(driver);
		a.dragAndDrop(element1, element2);
	}
	public static void screenShotRobot() throws AWTException {
		 r=new Robot();
		r.keyPress(KeyEvent.VK_WINDOWS);
		r.keyPress(KeyEvent.VK_PRINTSCREEN);
		r.keyRelease(KeyEvent.VK_WINDOWS);
		r.keyRelease(KeyEvent.VK_PRINTSCREEN);
	}
	public static void screenS(String filename) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Ramanathan\\eclipse-workspace\\maven\\TestNg\\ss"+filename+".png");
		FileUtils.copyFile(src, dest);
	}
	public static void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		
	}
	public static void escape() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
	}
	public static void avoidPopup() {
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--disable-notifications");
		driver=new ChromeDriver(op);
	}
	public static void createExxcel(String text,String filename) throws IOException {
		File file = new File("C:\\Users\\Ramanathan\\eclipse-workspace\\maven\\TestNg\\Excel\\"+filename+".xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet("Myexcel");
		Row r = s.createRow(0); 
		Cell c = r.createCell(0);
		c.setCellValue(text);
		FileOutputStream fout=new FileOutputStream(file);
		w.write(fout);
		}
	public static void fluentwait(WebElement element) {
		WebDriverWait w=new WebDriverWait(driver,4);
		w.until(ExpectedConditions.elementToBeClickable(element));
	}
	

	
	


	

}
