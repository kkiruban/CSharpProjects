package javaInterviewQuestion;

import java.util.Scanner;

public class panlidrome {

	public static void main(String[] args) {
		
//		String str="helloworld";
		
		Scanner sc=new Scanner(System.in);
		
		String str=sc.next();
		
		String reverse= "";
		
		for(int i=str.length()-1;i>=0;i--){
			
			reverse = reverse + str.charAt(i);
			
		}
		
		System.out.println(reverse);
		
		if (reverse.equals(str)){
			System.out.println("given str is panlidrome");
		}else
		{
			System.out.println("given string is not panlidrome");
		}

	}

}
