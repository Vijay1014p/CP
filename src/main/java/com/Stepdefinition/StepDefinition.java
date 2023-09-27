package com.Stepdefinition;



import java.lang.annotation.Target;

import org.junit.Assert;

import com.Baseclass.BaseClass;

import cucumber.api.java.en.Given;

public class StepDefinition extends BaseClass {
	
	@Given("^Enter Application \"([^\"]*)\"$")
	public void enter_Application(String arg1) throws Throwable {
		getUrl(BaseClass.getConfigDatas("URL"));
		Thread.sleep(3000);
	
	}

	@Given("^Click \"([^\"]*)\"$")
	public void click(String arg1) throws Throwable {
		elementClick(driver, arg1);
		Thread.sleep(3000);
	}

	@Given("^Enter text \"([^\"]*)\" \"([^\"]*)\"$")
	public void enter_text(String arg1, String arg2) throws Throwable {
		sendText(driver, arg1,arg2);
		Thread.sleep(3000);
		
	}

	@Given("^Click Radiobutton \"([^\"]*)\"$")
	public void click_Radiobutton(String arg1) throws Throwable {
	elementClick(driver, arg1);
	Thread.sleep(3000);
	    
	}

	@Given("^Verify text \"([^\"]*)\" \"([^\"]*)\"$")
	public void verify_text(String arg1, String arg2) throws Throwable {
		
		String Status =BaseClass.getElementText(arg1);
		
		System.out.println(Status);
		Assert.assertSame(Status,arg2);
		System.out.println(Status + arg2);
		Thread.sleep(3000);
		
	}
	
	@Given("^Verfiy \"([^\"]*)\"$")
	public void verfiy(String arg1) throws Throwable {
		
		elementDisplayed(driver, arg1);
		Thread.sleep(3000);
		
	}
	

}
