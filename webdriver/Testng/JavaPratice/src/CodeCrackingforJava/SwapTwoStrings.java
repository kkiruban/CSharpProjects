package CodeCrackingforJava;

public class SwapTwoStrings {

	public static void main(String[] args) {
		String str1, str2, strtemp;
        
		str1="kiruba";
		str2="nivethini";
		
        strtemp = str1;
        str1 = str2;
        str2 = strtemp;
        
        System.out.println("\nStrings after Swapping are :");
        System.out.print("String 1 = " +str1+ "\n");
        System.out.print("String 2 = " +str2+ "\n");

	}

}
