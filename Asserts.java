package TestNGActivities;

import org.testng.Assert;
import org.testng.annotations.Test;



public class Asserts {
  @Test
  public void AssertSuccessTest() {
	// Comparing two same Strings.
	  Assert.assertEquals("testng", "testng");
  }
  
  @Test
  public void AsserFailuretest() {
	// Comparing two different Strings
	  Assert.assertEquals("testng", "java");
  }
  
  @Test
  public void exceptionFailureTest() {
	  String ptr=null;
	//This line of code throws NullPointerException
	  ptr.equals("testng");
  }
  }
