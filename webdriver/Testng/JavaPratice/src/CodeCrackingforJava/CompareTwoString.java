package CodeCrackingforJava;

public class CompareTwoString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="kirubanand";
		String str1="kirubanand ramasamy";
		
		if(str.compareTo(str1)>0){
			System.out.println("First String is Greater than Second String.");
		}else if (str.compareTo(str1)<0) {
			System.out.println("First String is Smaller than Second String.");
		}else{
			System.out.println("Both Strings are Equal (i.e. String1 is Equal to String2)");
		}

	}

}
