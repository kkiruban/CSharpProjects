package interviewJava;

public class PrintOrNot {

	public static void main(String[] args) {
		

		int num=19,i,count=0;
		
		for(i=2;i<num;i++){
			
			if(num%i==0){
				
				count++;
				break;
				
			}
		}
		
		if(count==0){
			
			System.out.println("it is a prime no");
		}		
		else{
			System.out.println("it is not a prime no");
		}
		

	}

}
