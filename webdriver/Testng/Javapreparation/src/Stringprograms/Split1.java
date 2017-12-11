package Stringprograms;

import java.util.HashSet;
import java.util.Set;

public class Split1 {

	
	

	public static void main(String[] args) {
		
		String s1="kirubanand";
		Set<Character> set=new HashSet<Character>();
		char s2 = 0;
		
		for(int i=0;i<=s1.length()-1;i++){
			s2=s1.charAt(i);
			System.out.println(s2);
			set.add(s2);			
		}
		
		System.out.println(set);
		
		
	}

}
