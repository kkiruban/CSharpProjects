package Javapreparation;

public class Comparingwithstringequals {

	
	public static void main(String[] args) {
		String s1="kiruba";
		String s3= new String("kiruba");
		if(s1==s3){
			System.out.println("compares the given string");
		}else{
			System.out.println("compare the address ");
		}
			if(s1.equals(s3)){
				System.out.println("compares the given string");
			}else
			{
				System.out.println("compares the address");
			}

	}

}
