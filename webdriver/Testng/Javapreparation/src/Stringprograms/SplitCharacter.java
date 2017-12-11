package Stringprograms;

import java.util.HashSet;
import java.util.Set;

public class SplitCharacter {

	


	public static void main(String[] args) {
		Set<Character> set=new HashSet<Character>();
		String s1="kirubanand";
		String s2="kirubanand";
		char c1 = 0;
		String[] c=s1.split("");
		//System.out.println(c[0]);
		for(int i=0;i<=s1.length();i++){
			System.out.println(c[i]);
			String c2=c[i];
		
//			c1=s1.charAt(i);
//				System.out.println(c1);
			}
		  
		//set.add(c1);
		//System.out.println(set);
		Set<String> set1= new HashSet<String>();
		set1.add(s1);
		set1.add(s2);
		System.out.println(set1);
		}
		 
		

	}


