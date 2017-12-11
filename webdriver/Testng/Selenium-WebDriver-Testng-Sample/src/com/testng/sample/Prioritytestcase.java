package com.testng.sample;

import org.testng.annotations.Test;

public class Prioritytestcase {
  
	
	@Test(groups={"SmokeTest"})
	public void openbrowser() {
		System.out.println("open browser");
	}

	@Test(dependsOnMethods= {"openbrowser"},alwaysRun=true )
	public void flightbooking() {
		System.out.println("flight booking");
	}
	
	@Test(enabled=false)
	public void excludetestcase() {
		System.out.println("exclude the test case");
	}
	
	@Test(timeOut=5000)
	public void timerelated() {
		System.out.println("time related");
	}
	
}
