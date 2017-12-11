package stringfunctions;

public class SubString {

	public static void main(String[] args) {
		
		String s1= "kiruba the don";
		System.out.println(s1.length());

		System.out.println(s1.substring(0, 7));
		
		
		System.out.println(s1.toUpperCase()+ "-- upper case");
		System.out.println(s1.toLowerCase()+ "-- lower case");
		
		//replace a char 
		System.out.println(s1.replace("d", "g"));
		
		//replace all
		System.out.println(s1.replaceAll("don", ""));
	}

}
