package smallprogramsinterviewpreparation;

public class reversenumber {

	public static void main(String[] args) {
		
		int i=2345;
		int reverse=0;
		
		while(i!=0) {
			
			reverse=reverse*10;
			reverse=reverse+ i%10;
			i=i/10;
		}

		System.out.println(reverse);
	}

}
