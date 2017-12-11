package basicCoreJavaPrograms;

public class Panlidrome {

	public static void main(String[] args) {
		String g= "HelloWorld";
		String revstring="";
		
		for(int i=g.length()-1;i>=0;i--)
		{
			revstring =revstring + g.charAt(i);
		}
			 
		System.out.println(revstring);

		//== operator used to check  two strings are exactly the same object
		//equals function used to compare the exact value of the string
		
		 if (g.equals(revstring)){
			 System.out.println("given string is panlidrome");
		 }
		 else{
			 System.out.println("given string is not panlidrome");
		 }
			 

	}

}
