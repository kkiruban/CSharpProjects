package Middle;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test1 {

	public static void main(String[] args) throws IOException, InterruptedException {

   WebDriver driver =new FirefoxDriver();
   driver.get("http://my.naukri.com/manager/createacc2.php?othersrcp=7304&adnetwork=%22google%22&account=%22naukri%20search%22&campaign=%22brand%22&adgroup=%22naukri_exact%22&keyword=%22naukri%22&match=%22exact%22&lmd=%2216-may-2012%22&gclid=CJHN56Kjr7cCFWVS4godhhwApg");
   driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
   driver.findElement(By.name("BROWSECV")).click();
   Thread.sleep(5000);

	 Runtime.getRuntime().exec("C:\\Users\\kiruba\\Desktop\\kiru.exe");
//driver.findElement(By.linkText("Already registered? Sign in")).click();
   driver.findElement(By.xpath("//input[@name='BROWSECV']")).click();
System.out.println("pass");

	}

}
