package javaInterviewQuestion;

public class reverseNumber {

	public static void main(String[] args) {
		
		int number=1234;
		int temp=0;
		int reversedno=0;
	
		while(number >0){
			
			temp=number%10;
			
			reversedno=reversedno *10 + temp;
			
			number=number/10;
		}
		
		System.out.println(reversedno);
	}

}
