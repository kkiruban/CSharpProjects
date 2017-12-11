package CodeCrackingforJava;

public class palindrome {

	public static void main(String[] args) {
		
		String str="madam";
		String reverse="";
		
		for(int i=str.length()-1;i>=0;i--){
			
			reverse=reverse + str.charAt(i);
		}

		System.out.println(reverse);
		
		if(str.equalsIgnoreCase(reverse)){
			System.out.println("given string is panlindrome");
		}else {
			System.out.println("given string is not a palindrome");
		}
			
	}

}
