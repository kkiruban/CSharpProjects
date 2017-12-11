package Interviewprograms;

import java.util.HashSet;
import java.util.Set;

public class Duplicate {

	
	public static void main(String[] args) {
		Set<String> s1= new HashSet<String>();
		s1.add("kirubanand");
		System.out.println(s1);
		String s2="kirubanand";
		int l=s2.length();
		System.out.println(l);
		String[] arr=s2.split("");
		System.out.println(arr[1]);
//		public static void main(String[] args) {
//			// TODO Auto-generated method stub
//			
//			String s1="kirubanand"; char s2;
//			HashSet set1=new HashSet();
//			for(int i=0;i<s1.length();i++){
//				
//				 s2=s1.charAt(i);
//				System.out.println(s2);
//				set1.add(s2);
//				//String next=s1.substring(i+1);
//				//System.out.println(next);
//			}
//			
//			for(Object obj:set1){
//				System.out.println(set1);
//				
//		
//		
//	}
	}
}

