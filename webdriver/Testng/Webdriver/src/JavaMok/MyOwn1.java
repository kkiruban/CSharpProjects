package JavaMok;

public class MyOwn1 {

	public static void main(String[] args) {
		String s1="kirubanand";
		String s2="";
		int l=s1.length();
		for(int i=l-1;i>=0;i--){
			s2=s2+s1.charAt(i);
		}
		System.out.println(""+s2);
	   for(int i=1;i<=10;i++){
		   System.out.println(s2.substring(i));
	   }
	}

}
