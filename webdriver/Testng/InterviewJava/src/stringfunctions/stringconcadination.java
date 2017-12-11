package stringfunctions;

public class stringconcadination {

	public static void main(String[] args) {
		 
		String s1 = "kirubanand";
		String s2 = " Ramasamy";
		String s3 = "";
		
		s3=s1+s2;
		System.out.println(s3 + " using + operator");

		s3=s1.concat(s2);
		System.out.println(s3 + " using concat method");
	}

}
