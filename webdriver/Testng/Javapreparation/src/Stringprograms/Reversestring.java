package Stringprograms;

public class Reversestring {

	
	public static void main(String[] args) {
		String s1= "kiruba";
		String s2= " ";
		int l=s1.length();
		for(int i=l-1;i>=0;i--){
			s2=s2+s1.charAt(i);
		}
		System.out.println(s2);
		
	}

}
