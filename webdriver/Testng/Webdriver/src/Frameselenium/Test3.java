package Frameselenium;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test3 {
  @Test
  public void testcase1() {
	  System.out.println("verify customer");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("login to app");
	  System.out.println("create customer");
	  
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("logout");
  }
  
	
		
	
  @Test
  public void testcase2() {
	  System.out.println("modify customer");
	  System.out.println("verify customer");
  }
	
	  
  
}
