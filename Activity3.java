package TestNGActivities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity3 {
	WebDriver driver;
	
	
	 @BeforeClass
	  public void beforeClass() {
		 driver= new ChromeDriver();
		 
		 //Open browser
		 driver.get("https://www.training-support.net/selenium/login-form");
		 }
	 
  @Test
  public void loginTest() throws InterruptedException {
	//Find the username and password fields
	  WebElement username=driver.findElement(By.id("username"));
	  WebElement password=driver.findElement(By.id("password"));
	  Thread.sleep(5000L);
	  
	//Enter credentials
	  username.sendKeys("admin");
	  password.sendKeys("password");
	  Thread.sleep(5000L);
	  
	  //Click on login button
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  Thread.sleep(5000L); 
	  
	  //Read login message
	  String loginMessage =driver.findElement(By.id("action-confirmation")).getText();
	  Assert.assertEquals(loginMessage, "Welcome Back, admin");
	   }
 

  @AfterClass
  public void afterClass() {
	  //Close browser
	  driver.close();
  }

}
