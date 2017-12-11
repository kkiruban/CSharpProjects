package FrameworkWebdriver;

import org.testng.annotations.Test;

public class Run2 {
  @Test
  public void thirdtest() {
	  System.out.println("create customer");
  }
  @Test(dependsOnMethods={"thirdtest"})
  public void fourthtest() {
	  System.out.println("verify customer");
  }
}
