package JavaMok;

public class Sample2 {

	
	public static void main(String[] args) {
	 String s1="javadeveloper";
	 String s2=" ";
	 int l=s1.length();
	 for(int i=l-1;i>=0;i--){
		 s2=s2+s1.charAt(i);
	 }
  System.out.println("s2="+s2);
	}

}
