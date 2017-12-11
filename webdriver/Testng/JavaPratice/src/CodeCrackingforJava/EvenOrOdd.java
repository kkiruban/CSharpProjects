package CodeCrackingforJava;

import java.util.Scanner;

public class EvenOrOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num;
        Scanner scan = new Scanner(System.in);
		
        System.out.print("Enter a Number : ");
        num = scan.nextInt();
		
        if(num%2 == 0)
        {
            System.out.print("This is an Even Number");
        }
        else
        {
            System.out.print("This is an Odd Number");
        }
		
	}

}
