package com.TestRunner;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.Baseclass.BaseClass;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\main\\java\\com\\Feature",glue="com.Stepdefinition",tags= {"@Url,@CreatedAccount"},
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:Reports\\report.html",	"pretty",
		"html:src\\resource\\java\\Library" , "json:src\\resource\\java\\Library\\cucumber.json","junit:src\\resource\\java\\Library\\cucumber.xml"},monochrome=true,strict=true) 


public class TestRunner {
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void setUp() throws Throwable {
			String configDatas = BaseClass.getConfigDatas("AppBrowser");
			driver = BaseClass.browerLaunch(configDatas);
			
		

	}
	
	@AfterClass
	public static void tearDown() throws Throwable {
		driver.quit();
		
		
		

	}
	
	
}
