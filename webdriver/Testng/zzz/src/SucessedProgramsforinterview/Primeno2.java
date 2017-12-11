package SucessedProgramsforinterview;

import java.util.Scanner;

public class Primeno2 {

	
	public static void main(String[] args) {
		
		int sum;
		Scanner scan=new Scanner(System.in);
		sum=scan.nextInt();
		int flag=0;
		for(int i=2;i<sum;i++){
			if(sum%i==0){
				System.out.println("no is not prime");
				flag=1;
				break;
			}

		}
		if(flag==0){
			System.out.println("no is prime");
		}

	}

}
