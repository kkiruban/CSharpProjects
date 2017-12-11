package AvaticsTestcases;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.avactis.ReportLib.ScreenShot;
import com.avatics.businesslib.Avatics1;
import com.avatics.genericlib.ExcelLib;
import com.avatics.genericlib.WebdriverCommonuitill;

public class Ecommercetest1 {
	public ExcelLib elib=new ExcelLib();
    public WebdriverCommonuitill wLib=new WebdriverCommonuitill();
    public Avatics1 a1=new Avatics1();
  @Test
  public void com() throws InvalidFormatException, IOException{
  	  a1.lunchBrowser("http://localhost/Avactis/avactis-system/admin/signin.php");
  	  String username=elib.getExeceldata("sheet1",1, 2);
	  String password=elib.getExeceldata("sheet1",1, 3);
	  a1.loginToApp(username, password);
	  wLib.waitForPageToLoad(5000); 
	  ScreenShot sh=new ScreenShot();
	  sh.scrrenshot("F:\\selenium\\");
	  
  }
}
