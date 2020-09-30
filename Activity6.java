package TestNGActivities;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity6 {
	WebDriver driver;
	WebDriverWait wait;
	
	
	
	@BeforeClass
	  public void beforeClass() {
		driver=new ChromeDriver();
		wait=new WebDriverWait(driver,10);
		
		//Open browser
		driver.get("https://www.training-support.net/selenium/login-form");
	}
	

  
  @Test
  @Parameters({"username", "password"})
  public void loginTestCase(String username,String password) {
	//Find username and pasword fields
	 WebElement usernameField=driver.findElement(By.id("username"));
	 WebElement passwordField=driver.findElement(By.id("password"));
	 //WebElement LoginButton=driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button"));
	 
	 //Enter values
	 usernameField.sendKeys(username);
	 passwordField.sendKeys(password);
	 
	 //Click Login
	 driver.findElement(By.cssSelector("button[type='submit']")).click();
	 
	 //Assert message
	 String loginMessage=driver.findElement(By.id("action-confirmation")).getText();
	 Assert.assertEquals("Welcome Back, admin",loginMessage );
	 
	 
	 
  }
  

  @AfterClass
  public void afterClass() {
	  //Close the browser
	  driver.close();
  }

}
