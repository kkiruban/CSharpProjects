package Frameselenium;
//dependentcy on method
import org.testng.annotations.Test;

public class Test9 {
  
  @Test(dependsOnMethods={"logintest"})
  public void createcustomertest() {
	  System.out.println("create customer");
  }
  @Test
  public void logintest() {
	  System.out.println("login to app");
  }
  
}
