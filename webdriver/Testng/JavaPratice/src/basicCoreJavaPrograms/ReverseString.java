package basicCoreJavaPrograms;

public class ReverseString {

	public static void main(String[] args) {
		
		//reverse string without any in built function
		String g= "HelloWorld";
		String revstring="";
		
		for(int i=g.length()-1;i>=0;i--)
		{
			revstring =revstring + g.charAt(i);
		}
			 
		System.out.println(revstring);

	}

}
