package CodeCrackingforJava;

public class PrimeOrNot {

	public static void main(String[] args) {
		int num, i, count=0;
        num=18;
		
        for(i=2; i<num; i++)
        {
            if(num%i == 0)
            {
                count++;
                break;
            }
        }
        
        if(count == 0)
        {
            System.out.print("This is a Prime Number");
        }
        else
        {
            System.out.print("This is not a Prime Number");
        }
		
	}

}
