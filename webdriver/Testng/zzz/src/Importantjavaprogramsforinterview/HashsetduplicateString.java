package Importantjavaprogramsforinterview;

import java.util.HashSet;

public class HashsetduplicateString {

	public static void main(String[] args) {
		HashSet s3=new HashSet();
		String s1="kirubanand";
		
		
		for(int i=0;i<s1.length();i++){
		char s2=s1.charAt(i);
			System.out.println(s2);
			s3.add(s2);
			
		}
		System.out.println(s3);

	}

}
