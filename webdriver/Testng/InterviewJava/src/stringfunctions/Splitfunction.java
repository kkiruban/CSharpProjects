package stringfunctions;

public class Splitfunction {

	public static void main(String[] args) {
		
		
		String s1="cap@kiru@ba26@gmai@l.c@om";
		
		String[] str=s1.split("@", 6);
		
		for(String a:str){
			
			System.out.print(a);
		}

	}

}
