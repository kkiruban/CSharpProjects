package Importantjavaprogramsforinterview;

public class Reverseno {
     public int reverseno(int number){
    	 int reverse=0;
    	 while(number!=0){
    		 reverse=(reverse*10)+(number%10);
    		 number=number/10;
    
    	 }
    	 return reverse;
     }
	public static void main(String[] args) {
      Reverseno r1=new Reverseno();
      System.out.println(r1.reverseno(98));
      
	}

}
