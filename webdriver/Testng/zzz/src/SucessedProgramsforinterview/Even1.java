package SucessedProgramsforinterview;

import java.util.Scanner;

public class Even1 {

	
	public static void main(String[] args) {
		int sum;
		Scanner scan=new Scanner(System.in);
		sum=scan.nextInt();
		if(sum%2==0){
			System.out.println("no is even");
		}else{
			System.out.println("no is odd");
		}
	}

}
