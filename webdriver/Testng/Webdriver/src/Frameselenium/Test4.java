package Frameselenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Test4 {
  @Test
  public void f() {
	  System.out.println("create customer");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("login");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("logut");
  }

}
