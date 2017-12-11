package stringfunctions;

public class reverseString {

	public static void main(String[] args) {
		
		String s1 = "madam";
		String reverse ="";
		
         for(int i=s1.length()-1;i>=0;i--){
        	 
        	 reverse=reverse+s1.charAt(i);
         }
		
		System.out.println(reverse); 
		
		if(s1.equals(reverse)){
			System.out.println("given string is panlindrome");
		}else{
			System.out.println("given string is not a panlindrome");
		}
		
	}

}
