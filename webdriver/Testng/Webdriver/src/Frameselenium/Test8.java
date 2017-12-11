package Frameselenium;

import org.testng.annotations.Test;

public class Test8 {

  @Test(groups={"smokeTest","execute"})
  public void thridtest() {
    System.out.println("thrid test");
  }
  @Test(groups={"regressionTest","execute"})
  public void fourthtest() {
    System.out.println("fourth");
  }
  
}
