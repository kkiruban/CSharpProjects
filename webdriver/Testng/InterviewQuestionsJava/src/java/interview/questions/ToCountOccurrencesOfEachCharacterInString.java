package java.interview.questions;

import java.util.HashMap;

public class ToCountOccurrencesOfEachCharacterInString {

	static void characterCount(String inputString)
    {

	  HashMap<Character, Integer> countmap= new HashMap<Character, Integer>();
	  
	  //converting given string to char array
	  
	  char[] strarray=inputString.toCharArray();
	  
	  for(char c: strarray){
		  
		  if(countmap.containsKey(c)){
			  countmap.put(c,countmap.get(c)+1);
		  }else
          {
              //If char is not present in charCountMap,
              //putting this char to charCountMap with 1 as it's value

			  countmap.put(c, 1);
          }
	  }
	  
		
    }	
	
	public static void main(String[] args) {

		characterCount("Bitter Butter");

	}

}
