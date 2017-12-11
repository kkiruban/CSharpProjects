package Importantjavaprogramsforinterview;

import java.util.HashSet;

public class Hashset {

	
		public static void main(String[] args) {
			
			
			String s1="kirubanand"; char s2;
			HashSet set1=new HashSet();
			for(int i=0;i<s1.length();i++){
				
				 s2=s1.charAt(i);
				System.out.println(s2);
				set1.add(s2);
				//String next=s1.substring(i+1);
				//System.out.println(next);
			}
			
			for(Object obj:set1){
				System.out.println(set1);
				

	}
		}
		}
