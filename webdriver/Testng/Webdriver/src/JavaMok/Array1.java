package JavaMok;

public class Array1 {

	public static void main(String[] args) {
	  int [] array=new int[5];
	   array[0]=15;
	   array[1]=25;
	   array[2]=35;
	   array[3]=45;
	   array[4]=55;
	   System.out.println("array size="+array.length);
	   int b=array[0];
	   for(int i=0;i<=array.length-1;i++){
		   System.out.println(array[i]);
		   if(array[i]>b){
			   b=array[i];
		   }
	   }
	   System.out.println("b="+b);

	}

}
