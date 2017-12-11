package javaInterviewQuestion;

public class starPattern {

	public static void main(String[] args) {
		
//		int space=4;
//		for(int i=1;i<=5;i++){
//			
//			//print spaces
//            for(int j=1; j<=space;j++)
//                System.out.print(" ");
//             
//            //print stars
//            for(int j=1; j<=i; j++)
//                System.out.print("* ");
//             
//            //print new line
//            System.out.println();
//            space--;     			
//			
//		}
		
		int space=0;
        for(int i=5; i>=1; i--)
        {
            //print spaces
            for(int j=1; j<=space;j++)
                System.out.print(" ");
             
            //print stars
            for(int j=1; j<=i; j++)
                System.out.print("* ");
             
            //print new line
            System.out.println();
            space++;
             
        }
		

	}

}
