package java.interview.questions;

public class reversestring {

	public static void main(String[] args) {
		
		String str="kiruba";
		String reverse = "";
		
		for(int i=str.length()-1;i>=0;i--){
			
			reverse= reverse + str.charAt(i);
		}
		
		System.out.println(reverse);

	}

}
