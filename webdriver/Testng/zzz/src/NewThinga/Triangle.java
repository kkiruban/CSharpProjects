package NewThinga;

import java.util.Scanner;

public class Triangle {

	
	public static void main(String[] args) {
		
		int row,i,j;
		
		Scanner s1=new Scanner(System.in);
		System.out.println("enter the string");
		row=s1.nextInt();
		for(i=1;i<=row;i++){
			for(j=1;j<=i;j++){
				System.out.print(j);
			}
			 System.out.print("\n");
		}
		
	}

}
