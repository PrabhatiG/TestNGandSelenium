package TestNGActivities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class Activity9 {
	WebDriver driver;
	
	@BeforeClass
	  public void setUp() {
	   //new instance
		driver=new FirefoxDriver();
		
		Reporter.log("Starting Test");
		
		//Open browser
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		Reporter.log("Opened browser");
		
		//Print title of page
		Reporter.log("title of page:" +driver.getTitle());
	  }
	
	@BeforeMethod
	  public void beforeMethod() {
		Reporter.log("Test case set up started");
		//driver.switchTo().defaultContent();
	  }

	@Test(priority=0)
  public void simpleAlertTestCase() throws InterruptedException {
		Reporter.log("simpleAlertTestCase() started");
		
		//Click the button to open a simple alert
		driver.findElement(By.id("simple")).click();
		Reporter.log("Simple Alert opened!");
		
		//Switch to alert window
		Alert simpleAlert=driver.switchTo().alert();
		Reporter.log("Switch focus to alert");
		
		//Get text in the alert box and print it
		String alertText=simpleAlert.getText();
		Reporter.log("Alert text is"+alertText);
		
		//Assertion
		Assert.assertEquals(alertText, "This is a JavaScript Alert!");
		simpleAlert.accept();
		
		Reporter.log("Alert closed");
		Reporter.log("test case ended");
		Thread.sleep(5000L);
	}
  
	@Test(priority=1)
	  public void confirmAlertTestCase() throws InterruptedException {
		Reporter.log("Confirm alert test case started");
		//Click the button to open a simple alert
		driver.findElement(By.id("confirm")).click();
		Reporter.log("Confirm alert opened!");
		
		//Switch to alert window
		Alert confirmAlert=driver.switchTo().alert();
		Reporter.log("Switch focus to Confirm alert");
		
		//Get text in the alert box and print it
		String confirmAlertText=confirmAlert.getText();
		Reporter.log("Alert text is"+confirmAlertText);
		
		//Assertion
		Assert.assertEquals("This is a JavaScript Confirmation!",confirmAlertText);
		confirmAlert.accept();
		
		Reporter.log("Alert closed");
		Reporter.log("test case ended");
		Thread.sleep(5000L);

	  }
	
	@Test(priority=2)
	  public void promptAlertTestCase() throws InterruptedException {
		Reporter.log("promptAlertTestCase() strted!");
		//Click to open alert prompt:
		driver.findElement(By.id("prompt")).click();
		Reporter.log("Alert prompt opened!");
		
		//Switch to alert window
		Alert promptAlert=driver.switchTo().alert();
		Reporter.log("Switch focus to alert prompt");
		
		//Get text in the alert box and print it
		String promptAlertText=promptAlert.getText();
		Reporter.log("Aert text is: "+promptAlertText);
		
		promptAlert.sendKeys("Awesome!");
		Reporter.log("Text entered in prompt alert");
		
		//Assertion
		Assert.assertEquals(promptAlertText, "This is a JavaScript Prompt!");
		 promptAlert.accept();
		 Reporter.log("Alert Closed");
		 Reporter.log("Test case ended");
		 Thread.sleep(5000L);
	  }
  

  @AfterClass
  
  public void afterClass() {
	  Reporter.log("Ending test");
	  driver.close();
  }

}
