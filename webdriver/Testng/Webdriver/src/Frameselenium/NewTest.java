package Frameselenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class NewTest{

  @Test
  public void f() {
	  System.out.println("create customer");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("login to app");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("logout from app");	  
  }


  @AfterClass
  public void afterClass() {
	  System.out.println("close browser and disconnect to db");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("launch browser and connect to db");
  }

}
