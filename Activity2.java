package TestNGActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Activity2 {
	WebDriver driver;
	
	@BeforeTest
	public void beforeMethod()
	{
		 //Create a new instance of the Firefox driver
		driver= new ChromeDriver();
		 //Open the browser
		driver.get("https://www.training-support.net/selenium/target-practice");
	}
	
	@Test
	public void testcase1() {
		 //This test case will pass
		String tittle=driver.getTitle();
		System.out.println("Tittle is :"+tittle);
		Assert.assertEquals("Target Practice", tittle);
		
	}
	@Test
	public void testcase2() {
	//This test case will Fail
		WebElement	blackButton=driver.findElement(By.cssSelector("body > div > div.activity.content > div > div.spaced > div > div > div > div:nth-child(2) > div:nth-child(3) > button.ui.black.button"));
		Assert.assertTrue(blackButton.isDisplayed());
		Assert.assertEquals(blackButton.getText(), "Black");
}
	@Test(enabled=false)
	public void testcase3()
{
		//This test case will be skipped and not counted
		String subHeading=driver.findElement(By.className("sub")).getText();
		Assert.assertTrue(subHeading.contains("Practice"));
		
		}
	@Test
	public void testcase4() {
		//This test will be skipped and will be be shown as skipped
		throw new SkipException("Skipping test case");
	}
	@AfterTest
	public void afterMethod()
	{
		//close the browser
		driver.close();
	}
	
	
}
