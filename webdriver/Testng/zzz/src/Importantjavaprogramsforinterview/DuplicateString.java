package Importantjavaprogramsforinterview;

import java.util.HashSet;



public class DuplicateString {

	public static void main(String[] args) {
          HashSet set11=new HashSet();		
		String s1="anand";
		char s2;
		int l=s1.length();
		for(int i=0;i<l;i++){
			s2=s1.charAt(i);
			System.out.println(s2);
			set11.add(s2);
		    
		}
		System.out.println(set11);
	}

}
