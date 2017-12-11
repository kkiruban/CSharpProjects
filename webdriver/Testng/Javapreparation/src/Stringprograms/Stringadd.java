package Stringprograms;

public class Stringadd {

	
	public static void main(String[] args) {
		
		String s1="kirub";
		String s2="anand";
		String s3=s1+s2;
		System.out.println(s3);
		StringBuilder sb=new StringBuilder();
		sb.append("ness");
		sb.replace(0, 5, "kiruba");
		sb.append(" technology");
		sb.append(" private");
		sb.append(" limited");
		System.out.println(sb);
		
	}

}
