package Frameselenium;
//grouping
import org.testng.annotations.Test;

public class Test7 {
  @Test(groups={"smokeTest","create smoke testcase"})
  public void firsttest() {
	  System.out.println("first");
  }
  @Test(groups={"regressionTest","execute"})
  public void secondtest() {
	  System.out.println("second");
  }
  
}
