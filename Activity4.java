package Activities;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Activity4 {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeTest
	  public void beforeTest() {
		driver=new ChromeDriver();
		wait=new WebDriverWait(driver,10);
		
		//Open the browser
		driver.get("https://alchemy.hguy.co/lms");
	  }
	
  @Test
  public void Testcase4() {
	  //Get the title of the second most popular course.
	 WebElement title= driver.findElement(By.xpath("//*[@id=\"post-71\"]/div[2]/h3"));
	 String titleText= title.getText();
	 //Print the title
	 System.out.println(titleText);
	 Assert.assertEquals("Email Marketing Strategies", titleText);
	  
  }
 
  @AfterTest
  public void afterTest() {
	  //Close the browser
	  driver.quit();
  }

}
