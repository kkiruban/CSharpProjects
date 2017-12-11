package intervviewjava;

public class occuranceOfCharString {

	public static void main(String[] args) {
		
		String str= "bitter butter";
		
	    //counting occurences of character with loop
		int charcount =0;
		
		for(int i=0;i<str.length();i++){
			
			if(str.charAt(i) == 'b') {
				
				charcount++;
			}
								
			
		}
		
		System.out.println("count of character 'b' on String: 'bitter butter' using for loop  " + charcount);
		
		
		
	
	}

}
