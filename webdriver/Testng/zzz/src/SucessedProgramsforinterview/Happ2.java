package SucessedProgramsforinterview;

import java.util.Scanner;

import org.openqa.selenium.internal.seleniumemulation.GetText;

public class Happ2 {

	
	public static void main(String[] args) {
		int row,i,j;
		Scanner scan=new Scanner(System.in);
		row=scan.nextInt();
		String e;
		Scanner scan1= new Scanner(System.in);
		e=scan1.next();
		for(i=1;i<=row;i++){
			for(j=i;j<=e.length();j++){
				System.out.println(e.substring(0,j) );
			}
			System.out.print("\n");
		}

	}

}
