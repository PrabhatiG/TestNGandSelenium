package TestNGActivities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class Activity10 {
	WebDriver driver;
	Actions builder;
	
	@BeforeClass
public void beforeClass() {
		driver=new FirefoxDriver();
		builder=new Actions(driver);
		
		//Open browser
		driver.get("https://www.training-support.net/selenium/sliders");
	  }
	
	
  @Test
  public void sliderToMiddleTest() {
	//Find slider
	  WebElement slider=driver.findElement(By.id("slider"));
	//Clicking on the slider element moves it to the middle
	  slider.click();
	  String volumeLevel=driver.findElement(By.cssSelector("span#value")).getText();
	  Reporter.log("Mid value: "+volumeLevel);
	  Assert.assertEquals(volumeLevel, "49");
  }
  @Test
  public void sliderToMaxTest() {
	//Find slider
	  WebElement slider=driver.findElement(By.id("slider"));
	//Drag the slider
	  builder.clickAndHold(slider).moveByOffset(75, 0).release().build().perform();
	  String maxVolLevel=driver.findElement(By.cssSelector("span#value")).getText();
	  Reporter.log("max value: "+maxVolLevel);
	  Assert.assertEquals(maxVolLevel, "100");
	
  }
  @Test
  public void sliderToMinTest() {
	//Find slider
	  WebElement slider=driver.findElement(By.id("slider"));
	//Drag the slider
	  builder.clickAndHold(slider).moveByOffset(-75, 0).release().build().perform();
	  String minVolLevel=driver.findElement(By.cssSelector("span#value")).getText();
	  Reporter.log("max value: "+minVolLevel);
	  Assert.assertEquals(minVolLevel, "0");
	
  }
  
  @Test
  public void sliderTo30Test() {
	//Find slider
	  WebElement slider=driver.findElement(By.id("slider"));
	//Drag the slider
	  builder.clickAndHold(slider).moveByOffset(-30, 0).release().build().perform();
	  String minVolLevel=driver.findElement(By.cssSelector("span#value")).getText();
	  Reporter.log("max value: "+minVolLevel);
	  Assert.assertEquals(minVolLevel, "30");
	
  }
  @Test
  public void sliderTo80Test() {
	//Find slider
	  WebElement slider=driver.findElement(By.id("slider"));
	//Drag the slider
	  builder.clickAndHold(slider).moveByOffset(80, 0).release().build().perform();
	  String minVolLevel=driver.findElement(By.cssSelector("span#value")).getText();
	  Reporter.log("max value: "+minVolLevel);
	  Assert.assertEquals(minVolLevel, "30");
	
  }

  @AfterClass
  public void afterClass() {
	  
	  driver.close();
  }
  

}
