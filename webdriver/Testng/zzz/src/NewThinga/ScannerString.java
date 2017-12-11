package NewThinga;

public class ScannerString {

	
	public static void main(String[] args) {
		String data=null;
		java.util.Scanner s1=new java.util.Scanner(System.in);
		System.out.println("enter the string:");
		data=s1.next();
		int l=data.length();
		for(int i=0;i<=l;i++){
			System.out.println(data.substring(0,i));
		}
		

	}

}
