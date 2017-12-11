package com.stepper.testase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.stepper.genriccomponent.Driver;

public class Testsuit2 {
  @Test
  public void f() {
	  
	  Driver.driver.get("http://localhost:8888/index.php?action=Login&module=Users");
	  
   String data= Driver.driver.findElement(By.xpath("//img[@title='The honest Open Source CRM']")).getAttribute("alt");
    System.out.println(data);
  }
}
