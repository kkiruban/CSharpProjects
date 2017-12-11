package smallprogramsinterviewpreparation;

public class compareStrings {

	public static void main(String[] args) {
	
		  String s1="kirubanand";
		  String s2="KIRUBANAND";
		  
		  if (s1.equalsIgnoreCase(s2)) {
		  System.out.println("both strings are matched");
		  }
		  else {
			  System.out.println("both strings are not matched");  
		  }

	}

}
