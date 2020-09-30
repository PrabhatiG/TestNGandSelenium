package Activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Activity8 {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeTest
	  public void beforeTest() {
		driver=new ChromeDriver();
		wait= new WebDriverWait(driver,10);
		
		//Open the browser
		driver.get("https://alchemy.hguy.co/lms");
		
		//maximise the window
		driver.manage().window().maximize();
		
	  }
   
	
	@Test
  public void TestCase8() throws InterruptedException {
		//Click on contact link	
		driver.findElement(By.xpath("//*[@id=\"menu-item-1506\"]/a")).click();
		Thread.sleep(5000L);
		
		//Locate the different fields:
		
		WebElement FullNameField=driver.findElement(By.xpath("//input[@type='text']"));
		WebElement EmailField=driver.findElement(By.xpath("//input[@type='email']"));
		WebElement CommentField=driver.findElement(By.xpath("//*[@id=\"wpforms-8-field_2\"]"));
		
		//Fill in different values:
		FullNameField.sendKeys("Prabhati");
		EmailField.sendKeys("pg@gmail.com");
		CommentField.sendKeys("Thank you");
		
		//Click on SendMessage Button:
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Read and print the message displayed after submission:
		String message=driver.findElement(By.xpath("//*[@id=\"wpforms-confirmation-8\"]/p")).getText();
		System.out.println(message);
  }
  

  @AfterTest
  public void afterTest() {
	  //Close the browser
	  driver.quit();
  }

}
