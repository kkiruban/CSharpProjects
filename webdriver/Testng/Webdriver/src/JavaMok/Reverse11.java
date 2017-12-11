package JavaMok;

public class Reverse11 {

	public int reverseno(int number){
		int reverse=0;
		while (number!=0){
			reverse=(reverse*10)+(number%10);
			number=number/10;
			
		}
		return reverse;
	}
	public static void main(String[] args) {
	   
		Reverse11 r1=new Reverse11();
		System.out.println(r1.reverseno(998));
	}

}
