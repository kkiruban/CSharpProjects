package SucessedProgramsforinterview;

import java.util.Scanner;

public class Happiestmindquestion1 {

	
	public static void main(String[] args) {
		String row;
		int i,j;
		Scanner scan=new Scanner(System.in);
		row = scan.next();
        int l=row.length();
        for(i=1;i<=l;i++){
        	System.out.println(row.substring(0, i));
        }
		
		

	}

}
