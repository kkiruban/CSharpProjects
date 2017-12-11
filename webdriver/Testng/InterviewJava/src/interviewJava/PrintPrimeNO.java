package interviewJava;

public class PrintPrimeNO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int start=1,end=20,i,j,count=0;
		
		
		for(i=start;i<=end;i++){
			
			count=0;
			
			for(j=2;j<i;j++){
				
				if(i%j==0){
					
					count++;
					break;
				}
				
			}
				
				if(count == 0){
					
					System.out.print(" " + i + " ");
				}
				
			}
			
		
	}

}
