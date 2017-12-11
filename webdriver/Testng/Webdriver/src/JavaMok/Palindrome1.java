package JavaMok;

public class Palindrome1 {

	
	public static void main(String[] args) {
		
		String s1="121";
		String s2="";
		int l=s1.length();
		for(int i=l-1;i>=0;i--){
			s2=s2+s1.charAt(i);
		}
     System.out.println("s2="+s2);
     if(s1.equalsIgnoreCase(s2)){
    	 System.out.println("string is palindrome");
     }else{
    	 System.out.println("string is not a palindrome");
     }
     
	}

}
