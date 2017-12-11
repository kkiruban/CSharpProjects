package AdvancedJavaprograms;

public class abiDuplicateCharacterinaString {

	public static void main(String[] args) {		
		String str="kirubanand";
		int count=0;
		
		for(int i=0;i<str.length();i++) {
			
			if(str.charAt(i)=='a') {
				
				count ++;
			}
		}
		
		System.out.println("character A occured no of times in a given string :" + count);
	}

}
