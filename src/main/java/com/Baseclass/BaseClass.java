package com.Baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	public static WebDriver driver;
	
	//Browser Launch
	public static WebDriver browerLaunch(String browerName) throws Exception {

		try {
			if (browerName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\resource\\java\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();

			} else if (browerName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resource\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browerName.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\src\\test\\resource\\Drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			} else {
				throw new Exception("Browser name id not valid");
			}

			return driver;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	//maximize the windows
	public static void maximize() {
		try {
			driver.manage().window().maximize();
		}catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		throw new RuntimeException();
		}
		

	}
	
	//URL
	public static void getUrl(String url) throws Throwable {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}
	
	
	
	//Get data from Test Configuration sheet
	
	
		public static String getConfigDatas(String value) throws Throwable {
			try {
				File f = new File(System.getProperty("user.dir") + "\\Data\\TestConfiguration.xlsx");
				FileInputStream fin = new FileInputStream(f);
				Workbook wb = new XSSFWorkbook(fin);
				Sheet sheetAt = wb.getSheetAt(0);
				String cellValue = null;
				for (int i = 0; i < sheetAt.getPhysicalNumberOfRows(); i++) {
					String stringCellValue = sheetAt.getRow(i).getCell(1).getStringCellValue();
					//System.out.println(stringCellValue);
					if (stringCellValue.equalsIgnoreCase(value)) {
						Cell cell = sheetAt.getRow(i).getCell(2);
						if (cell.getCellType().equals(CellType.STRING)) {
							cellValue = cell.getStringCellValue();
						} else if (cell.getCellType().equals(CellType.NUMERIC)) {
							double numericCellValue = cell.getNumericCellValue();
							long l = (long) numericCellValue;
							cellValue = String.valueOf(l);
						}
					}
				}
				return cellValue;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new Exception();
			}
		}
		
	
	
	
	//Input values to Element
	
	public static void sendText(WebDriver driver,String xpath,String element) throws Throwable {
		try {
			
			String fileName = BaseClass.getConfigDatas("OR");
			Properties obj = new Properties();	
			
			//Setting Path to File
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\com\\pom\\" + fileName + ".properties" );
			 
		 //Load the Locators
			 
			obj.load(objfile);
			
			
			
			WebElement webElement = driver.findElement(By.xpath(obj.getProperty(xpath)));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();",webElement);
			webElement.sendKeys(element);
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		

		}
	}
	
	//Clear and Type
	public static void clearAndType(WebDriver driver,String xpath,String element) throws Throwable {
		try {
			
			String fileName = BaseClass.getConfigDatas("OR");
			Properties obj = new Properties();	
			
			//Setting Path to File
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\com\\pom\\" + fileName + ".properties" );
			 
			
			 //Load the Locators
			 
			obj.load(objfile);
			
			WebElement webElement = driver.findElement(By.xpath(obj.getProperty(xpath)));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", webElement);
			webElement.clear();
			webElement.sendKeys(element);
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}
	
	//Element click
	
	public static  void elementClick(WebDriver driver,String element) throws Throwable {
		
		try {
			
		
		
			//Passing OR Application properties path
			String fileName = BaseClass.getConfigDatas("OR");
				
		
				
			Properties obj = new Properties();	
				
			//Setting Path to File
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\com\\pom\\" + fileName + ".properties" );
				 
						 
			obj.load(objfile);
				
			WebElement webElement = driver.findElement(By.xpath(obj.getProperty(element)));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", webElement);
			webElement.click();
							
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

			}
		}
	
	
	
	//Element displayed
	
	public static boolean elementDisplayed(WebDriver driver,String element) throws Throwable {
		boolean displayed = false;
		try {
			
			String fileName = BaseClass.getConfigDatas("OR");
			Properties obj = new Properties();	
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\com\\pom\\" + fileName + ".properties" );
			obj.load(objfile);
			
			WebElement webElement = driver.findElement(By.xpath(obj.getProperty(element)));
			displayed = webElement.isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
		return displayed;

	}
	
	//Element Enabled
	
	public static boolean elementEnabled(WebDriver driver,String element) throws Throwable {
		try {
			String fileName = BaseClass.getConfigDatas("OR");
			Properties obj = new Properties();	
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\com\\pom\\" + fileName + ".properties" );
			obj.load(objfile);
			
			WebElement webElement = driver.findElement(By.xpath(obj.getProperty(element)));
			
			boolean enabled = webElement.isEnabled();
			return enabled;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}
	
	//Element is selected
	
	public static boolean elementSelected(WebDriver driver,String element) throws Throwable {
		try {
			
			String fileName = BaseClass.getConfigDatas("OR");
			Properties obj = new Properties();	
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\com\\pom\\" + fileName + ".properties" );
			obj.load(objfile);
			
			WebElement webElement = driver.findElement(By.xpath(obj.getProperty(element)));
			
			boolean selected = webElement.isSelected();
			return selected;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}
	
	//Visbility of element
	
	public static void waituntilElementVisibility(WebDriver driver,String element) throws Throwable {
		try {
			
			String fileName = BaseClass.getConfigDatas("OR");
			Properties obj = new Properties();	
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\com\\pom\\" + fileName + ".properties" );
			obj.load(objfile);
				
			WebElement webElement = driver.findElement(By.xpath(obj.getProperty(element)));
			
			WebDriverWait wb = new WebDriverWait(driver, 50);
			wb.until(ExpectedConditions.visibilityOf(webElement));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	//Element Clear
	public static void elementClear(WebDriver driver,String element) throws Throwable {
		try {
			String fileName = BaseClass.getConfigDatas("OR");
			Properties obj = new Properties();	
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\com\\pom\\" + fileName + ".properties" );
			obj.load(objfile);
				
			WebElement webElement = driver.findElement(By.xpath(obj.getProperty(element)));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			webElement.clear();

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}
	
	
	//Get Element text
	public static String getElementText(String element) throws Throwable {
		try {
			
			String fileName = BaseClass.getConfigDatas("OR");
			Properties obj = new Properties();	
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\com\\pom\\" + fileName + ".properties" );
			obj.load(objfile);
				
			WebElement webElement = driver.findElement(By.xpath(obj.getProperty(element)));
			
			String text = webElement.getText();
			return text;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}
	
	//Waittime
	public void waitTime(WebDriver driver, int inputData) throws InterruptedException {
		
		
		int seconds = inputData * 1000;
		Thread.sleep(seconds);
		
	}
	
	//select value form dropdown
	public static void selectValuesfromDD(String element, String options, String value) throws Throwable {
		try {
			
			String fileName = BaseClass.getConfigDatas("OR");
			Properties obj = new Properties();	
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\com\\pom\\" + fileName + ".properties" );
			obj.load(objfile);
				
			WebElement webElement = driver.findElement(By.xpath(obj.getProperty(element)));
		
			Select sc = new Select(webElement);
			if (options.equalsIgnoreCase("value")) {
				sc.selectByValue(value);
			} else if (options.equalsIgnoreCase("visibletext")) {
				sc.selectByVisibleText(value);
			} else if (options.equalsIgnoreCase("index")) {
				sc.selectByIndex(Integer.parseInt(value));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	//ScrollUsingelement
	public void scrollUpandScrollDownusingElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}
	
	
	
	
	
	
	
	
	

}
