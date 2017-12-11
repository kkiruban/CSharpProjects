package Javapreparation;

public class AddString {

	public static void main(String[] args) {
		String s1="ness technology";
		System.out.println(s1);
		String s2=" private limited";
		System.out.println(s2);
		String s3=s1+s2;
		System.out.println(s3);
		StringBuilder stb=new StringBuilder();
		stb.append("kiruba");
		stb.replace(0, 5, "aburik");
		stb.append(" the");
		stb.append(" great");
		System.out.println(stb);
		
	}

}
