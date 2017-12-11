package SucessedProgramsforinterview;

public class Primeno1 {

	
	public static void main(String[] args) {
		int value=100;
		int count = 0;
		for(int i=1;i<100;i++){
			Boolean prime=true;
			for(int j=2;j<i;j++){
				if(i%j==0){
					prime=false;
					break;
				}
			}
			if(prime){
				System.out.println(i);
				count=count+1;
			}
		}
		System.out.println("no of prime no within 100="+count);
		
	}

}
