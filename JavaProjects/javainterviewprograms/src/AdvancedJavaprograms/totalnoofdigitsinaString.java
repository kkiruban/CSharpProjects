package AdvancedJavaprograms;

public class totalnoofdigitsinaString {

	public static void main(String[] args) {
		
		String str="kiru262626";
		
		 int count=0;
		 
		 for(int i=0;i<str.length();i++) {
			 
			 char ch=str.charAt(i);
			 
			 if(Character.isDigit(ch)) {
				 System.out.print(ch);
				 count ++;
			 }
			 
		 }
		 System.out.println();
		 
		 System.out.println(count);

	}

}
