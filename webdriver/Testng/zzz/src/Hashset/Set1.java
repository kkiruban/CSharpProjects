package Hashset;

import java.util.HashSet;
import java.util.Set;

public class Set1 {

	
	public static void main(String[] args) {
		
		String s = "kirubanand";
	    Set<Character> set = new HashSet<Character>();
	    for(char c : s.toCharArray()){
	        set.add(c);
	    }
	    System.out.println(set);

	}

}
