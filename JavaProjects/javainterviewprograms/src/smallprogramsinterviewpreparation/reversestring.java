package smallprogramsinterviewpreparation;

public class reversestring {

	public static void main(String[] args) {
		
		String str1="madam";
		
		String reverse="";
		
		
		for(int i=str1.length()-1;i>=0;i--) {
			
			reverse=reverse+str1.charAt(i);
		}
		
		System.out.println(reverse);

	}

}
