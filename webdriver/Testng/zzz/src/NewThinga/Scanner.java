package NewThinga;

import java.io.InputStream;



public class Scanner {

	

	public static void main(String[] args) {
		int row,i,j;
	  java.util.Scanner s1= new java.util.Scanner(System.in);
	System.out.println("enter the no of row");
	  row=s1.nextInt();
		
	  for(i=1;i<=row;i++){
		  for(j=1;j<=i;j++){
			  System.out.print(j);
		  }
		  System.out.print("\n");
		  
	  }
	}

}
