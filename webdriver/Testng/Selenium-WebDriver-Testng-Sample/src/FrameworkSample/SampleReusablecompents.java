package FrameworkSample;

import java.io.IOException;

import org.testng.annotations.Test;

public class SampleReusablecompents extends TestBase {
  
	@Test
  public void FillCredentialsInLoginPage() throws IOException {
	  Login();
	  
  }
}
