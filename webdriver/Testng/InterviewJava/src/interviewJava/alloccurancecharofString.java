package interviewJava;

import java.util.HashMap;

public class alloccurancecharofString {

	public static void countstring(String inputstring){
		
		HashMap<Character, Integer> countmap = new HashMap<Character, Integer>();
		
		char[] strarray=inputstring.toCharArray();
		
		System.out.println(strarray);
		
		for(char c:strarray){
			
			if(countmap.containsKey(c)){
				
				countmap.put(c, countmap.get(c)+1);
			}else{
				
				countmap.put(c, 1);
			}
		}
		
		System.out.println(countmap);
		
	}
	
	
	public static void main(String[] args) {
		countstring("kirukirukiru");
	}

}
