package SucessedProgramsforinterview;

import java.util.Scanner;

public class HappeistMindQuestions {

	
	public static void main(String[] args) {
		
      int row,i,j;
      Scanner scan1=new Scanner(System.in);
      row=scan1.nextInt();
      for(i=1;i<=row;i++){
    	  for(j=1;j<=i;j++){
    		   System.out.print(j);
    	  }
    	  System.out.print("\n");
      }
	}

}
