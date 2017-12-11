package smallprogramsinterviewpreparation;

public class primenumber {

	public static void main(String[] args) {
		
		int n=18;
		int m;
		int count=0;
		
		m=n/2;
		
		for(int i=2;i<=m;i++) {
			
			if(n%i==0) {
			
				count=1;
				break;
			}			
			
		}
		if(count==0) {
			System.out.println("it is a prime number");
		}else {
			System.out.println("it is not a prime number");
		}
		
		
	}

}
