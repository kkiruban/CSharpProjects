package CodeCrackingforJava;

public class BubbleSorttest {

	public static void main(String[] args) {
		
		int n,temp,i,j;
		
		int[] array={90,20,30,50,70,80,40};
		
	    n=array.length;
	    
	    
	    for(i=0;i<(n-1);i++){
	    		    	 
	    	 for(j=0;j<(n-i-1);j++){
	    		 
	    		 if(array[j] > array[j+1]){
	
	    			 temp=array[j];
	    			 array[j]=array[j+1]; 
	    			 array[j+1]=temp;
	    			 
	    		 }
	    	 }
	    
	    }
	    
	    System.out.print("Array Sorted Successfully..!!\n");
		   
	       System.out.print("Sorted List in Ascending Order : \n");
	    
	    for(i=0;i<n;i++){
	    	System.out.println(array[i]);
	    }
		
		
	}

}
