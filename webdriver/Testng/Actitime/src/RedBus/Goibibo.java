package RedBus;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Goibibo {

	
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://api.goibibo.com/bus/");
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.findElement(By.id("gi_dest_text_1")).clear();
		driver.findElement(By.id("gi_dest_text_1")).sendKeys("Bangalore");
		driver.findElement(By.id("gi_dest_text_2")).clear();
		driver.findElement(By.id("gi_dest_text_2")).sendKeys("channai");
		
		driver.findElement(By.xpath("//div[text()='Depart']/following-sibling::a/span[3]")).click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		String dateno="22/aug/2013";
		String arr[]=new String[3];
			arr	=dateno.split("/");
			String expdate=arr[0];
			String expmth=arr[1];
			String expyr=arr[2];
			System.out.println("arr:"+expdate);
			System.out.println("arr:"+expmth);
			System.out.println("arr:"+expyr);
			
		String arr1=driver.findElement(By.xpath("//div[@class='gmnta']/span")).getText();
		System.out.println("arr1:"+arr1);
		String arr2[]=new String[3];
		arr2=arr1.split(" ");
		String actmth=arr2[1];
		String actyr=arr2[2];
		System.out.println("arr2:"+arr2[0]);
		System.out.println("actmth:"+actmth);
		System.out.println("actyr:"+actyr);
		if(expyr.equals(actyr)){
			System.out.println("inside yr equals");
			if(expmth.equalsIgnoreCase(actmth)){
					System.out.println("inside mth equals");
					List<WebElement> wblist=driver.findElements(By.xpath("//div[@class='gmnta']/p/em"));
					for(int i=0;i<wblist.size();i++){
							String actlist=wblist.get(i).getText();
							if(arr[0].equals(actlist)){
									wblist.get(i).click();
									System.out.println("Date is selected sucessfully.");
							}
					}
				
			}
			else{
				System.out.println("inside mth else equals");
				do{
					driver.findElement(By.id("gnext")).click();
					arr1=driver.findElement(By.xpath("//div[@class='gmnta']/span")).getText();
					arr2=arr1.split(" ");
					actmth=arr2[1];
					actyr=arr2[2];
					System.out.println("actmth:"+actmth);
					System.out.println("actyr:"+actyr);

					System.out.println("inside do while of else mth");
				}while(!(expmth.equalsIgnoreCase(actmth)));
				
				List<WebElement> wblist=driver.findElements(By.xpath("//div[@class='gmnta']/p/em"));
				for(int i=0;i<wblist.size();i++){
					String actlist=wblist.get(i).getText();
					if(expdate.equals(actlist)){
						wblist.get(i).click();
						System.out.println("Date is selected sucessfully.");
					}
					
				}
			}
		}else{
			System.out.println("inside yr else part equals");
			do{
				driver.findElement(By.id("gnext")).click();
				arr1=driver.findElement(By.xpath("//div[@class='gmnta']/span")).getText();
				arr2=arr1.split(" ");
				actmth=arr2[1];
				actyr=arr2[2];
			}while(!(expyr.equals(actyr)));
			
			
			do{
				driver.findElement(By.id("gnext")).click();
			}while(!(expmth.equalsIgnoreCase(actmth)));
			
			List<WebElement> wblist=driver.findElements(By.xpath("//div[@class='gmnta']/p/em"));

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
