package CodeCrackingforJava;

public class FibanacciSeries {

	public static void main(String[] args) {
	    
		
		int a=0,b=1,c=0,limit=10;
		
		System.out.print("fibonnaci series : " + a + " " + b);
		c=a+b;
       
//		System.out.println(c);
		
		
		limit=limit-2;

//		System.out.println(limit);	
		
		while (limit>0) {
			
			System.out.print(" " + c + " ");
			
			a=b;
			b=c;
			c=a+b;
			limit--;
			
		}
		
	}

}
