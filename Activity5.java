package TestNGActivities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Activity5 {
	WebDriver driver;
	//Include alwaysRun property on the @BeforeTest
    //to make sure the page opens
	
	@BeforeTest(alwaysRun=true)
	  public void beforeTest() {
		//Create a new instance of the Chrome driver
		driver=new ChromeDriver();
		
		//Open the browser
		driver.get("https://www.training-support.net/selenium/target-practice");
		}
	
  @Test(groups= {"Header tests","ButtonTests"})
  public void pageTitleTest() {
	  String title=driver.getTitle();
	  System.out.println("Page title is:"+title);
	  Assert.assertEquals(title, "Target Practice");
	   }
  
  @Test(dependsOnMethods= {"pageTitleTest"},groups= {"HeaderTests"})
  public void HeaderTest1() {
	  WebElement header3= driver.findElement(By.xpath("//h3[@id='third-header']"));
	  Assert.assertEquals(header3.getText(), "Third header");
  }
  
  @Test(dependsOnMethods= {"pageTitleTest"},groups= {"HeaderTests"})
  public void HeaderTest2() {
	  WebElement header3= driver.findElement(By.xpath("//h3[@id='third-header']"));
	  Assert.assertEquals(header3.getCssValue("color"), "rgba(251, 189, 8, 1)");
	  
  }
  
  @Test(dependsOnMethods= {"pageTitleTest"},groups= {"ButtonTests"})
  public void ButtonTest1()
  {
	  WebElement button1=driver.findElement(By.xpath("//button[@class='ui olive button']"));
	  Assert.assertEquals(button1.getText(), "Olive");
  } 
  
  @Test(dependsOnMethods= {"pageTitleTest"},groups= {"ButtonTests"})
  public void ButtonTest2()	
  {
	  WebElement button2=driver.findElement(By.cssSelector("button.brown"));
	  String color=button2.getCssValue("color");
	  System.out.println(color);
	  Assert.assertEquals(button2.getCssValue("color"), "rgba(255, 255, 255, 1)");
  }
	  
	  
//Include alwaysRun property on the @AfterTest
  //to make sure the page closes
  
  @AfterTest(alwaysRun=true)
  public void afterTest() {
	  //Close the browser
	  driver.close();
  }

}
