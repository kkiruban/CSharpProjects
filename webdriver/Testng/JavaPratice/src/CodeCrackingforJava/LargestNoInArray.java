package CodeCrackingforJava;

public class LargestNoInArray {

	public static void main(String[] args) {
		
		
		int[] arr={30,40,90,91,93,95,55,99};
		int n=arr.length;
		
		int large=arr[0];
		
		for(int i=0;i<n;i++){
			
			if(large < arr[i]){
				
				large=arr[i];
			}
			
		}
		
		System.out.println(large);
		

	}

}
