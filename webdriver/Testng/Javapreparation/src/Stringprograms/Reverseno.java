package Stringprograms;

public class Reverseno {

	public static void main(String[] args) {
		int num=987;
		int reverse=0;
		while(num!=0){
			reverse= (reverse*10)+(num%10);
			num=num/10;
			System.out.println(num);
		}
       System.out.println(reverse);
	}

}
