package CodeCrackingforJava;

public class Smallestnoinarray {

	public static void main(String[] args) {
		
		
		int[] arr={90,20,30,40,12,8,9,10,11,12};
		int n=arr.length;
		
		
		int small=arr[0];
		
		for(int i=0;i<n;i++){
			
			if(small>arr[i]){
				
				small=arr[i];
			}
		}

		System.out.println(small);
	}

}
