package Stringprograms;

public class palindrome {

	
	public static void main(String[] args) {
		String s1="madam";
		String s2= "" ;
		int l=s1.length();
		for(int i=l-1;i>=0;i--){
			s2=s2+s1.charAt(i);
		}
		System.out.println(s2);
		if (s1.equals(s2)){
			System.out.println("given string is palindrome");
		}else{
			System.out.println("given string is not a palindrome");
		}

	}

}
