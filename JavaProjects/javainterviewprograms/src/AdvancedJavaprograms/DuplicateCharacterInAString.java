package AdvancedJavaprograms;

public class DuplicateCharacterInAString {

	public static void main(String[] args) {
		
		 String str="kirubanand ramasamy";
		  int count=0;
		  char[] inp=str.toCharArray();
		  
		  for(int i=0;i<str.length();i++) {
			  
			  for(int j =i+1;j<str.length();j++) {
				  
				  if(inp[i]==inp[j]) {
					  System.out.print(inp[j] + ",");
					  count ++;
					  break;
				  }
			  }	  
		  }
			
	}

}
