package JavaMok;

public class ReverseNo {

	 public int reverseNumber(int number){
		
		        int reverse = 0;
		        //System.out.println(reverse);
		        while(number != 0){
		            reverse = (reverse*10)+(number%10);
		           // System.out.println(reverse);
		            number = number/10;
		            //System.out.println(number);
		        } 
		        return reverse;
		    }
		     
		    public static void main(String[] args){
		        ReverseNo nr = new ReverseNo();
		        System.out.println("Result: "+nr.reverseNumber(17868));
		    }
		}

	


