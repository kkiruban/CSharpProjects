package RedBus;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Calcontrolinredbus {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://redbus.in");
		driver.manage().timeouts().implicitlyWait(15000,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//img[@alt='Select your date of journey']")).click();
		Thread.sleep(3000);
			
		String dateno="22/May/2015";
		String arr[]=new String[3];
			arr	=dateno.split("/");
				
		String getyr=driver.findElement(By.xpath(".//*[@ class='cal_container Cal']/div/div/table[1]/tbody/tr[1]/td[3]")).getText();
		String getmonth=driver.findElement(By.xpath("//div[@class='cal_container Cal']/div/div/table[1]/tbody/tr[1]/td[2]")).getText();
		System.out.println("exp yr: "+getyr);
		System.out.println("actual yr: "+arr[2]);
		System.out.println("exp month: "+getmonth);
		System.out.println("actual month: "+arr[1]);
		
		if(arr[2].equals(getyr)){
			
				if(arr[1].equals(getmonth)){
					
					List<WebElement> wblist=driver.findElements(By.xpath("//div[@class='cal_container Cal']/div/div/table[1]/tbody/tr/td/a"));
					for(int i=0;i<wblist.size();i++){
						String actlist=wblist.get(i).getText();
						if(arr[0].equals(actlist)){
							wblist.get(i).click();
							System.out.println("Date is selected sucessfully.");
						}
						
					}
					
				}else{
					String s2;
					do{
						driver.findElement(By.xpath("//div[@class='cal_container Cal']/div/div/table[1]/tbody/tr[1]/td[4]")).click();
						String getmonth1=driver.findElement(By.xpath(".//*[@ class='cal_container Cal']/div/div/table[1]/tbody/tr[1]/td[2]")).getText();
						s2=getmonth1;
					}while(!(arr[1].equals(s2)));
					
					List<WebElement> wblist=driver.findElements(By.xpath("//div[@class='cal_container Cal']/div/div/table[1]/tbody/tr/td/a"));
					for(int i=0;i<wblist.size();i++){
						String actlist=wblist.get(i).getText();
						if(arr[0].equals(actlist)){
							wblist.get(i).click();
							System.out.println("Date is selected sucessfully.");
						}
						
					}
				}
		}else{
			String s1;
			do{
			driver.findElement(By.xpath("//div[@class='cal_container Cal']/div/div/table[1]/tbody/tr[1]/td[4]")).click();
			String getyr1=driver.findElement(By.xpath(".//*[@ class='cal_container Cal']/div/div/table[1]/tbody/tr[1]/td[3]")).getText();
			s1=getyr1;
			}while(!(arr[2].contentEquals(s1)));
			
			String s2;
			do{
				driver.findElement(By.xpath("//div[@class='cal_container Cal']/div/div/table[1]/tbody/tr[1]/td[4]")).click();
				String getmonth1=driver.findElement(By.xpath(".//*[@ class='cal_container Cal']/div/div/table[1]/tbody/tr[1]/td[2]")).getText();
				s2=getmonth1;
			}while(!(arr[1].equals(s2)));
			
			List<WebElement> wblist=driver.findElements(By.xpath("//div[@class='cal_container Cal']/div/div/table[1]/tbody/tr/td/a"));
			for(int i=0;i<wblist.size();i++){
				String actlist=wblist.get(i).getText();
				if(arr[0].equals(actlist)){
					wblist.get(i).click();
					System.out.println("Date is selected sucessfully.");
				}
				
			}
		}
	}

}
