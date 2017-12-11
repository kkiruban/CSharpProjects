package Stringprograms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ToReadfile {

	
	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("C:\\Users\\kiruba\\Desktop\\kiru.txt");
        String inputStreamString = new Scanner(fis,"UTF-8").useDelimiter("\\A").next();
        System.out.println(inputStreamString);
        int l=inputStreamString.length();
        System.out.println(l);
        String expectedstring="good";
        int count=0;
        
             if(inputStreamString.contains(expectedstring)){
        	System.out.println("fuck");
        	count=count+1;
        	System.out.println(count);
        }else
        {
        	System.out.println("ha");
        }

//Read more: http://javarevisited.blogspot.com/2012/08/convert-inputstream-to-string-java-example-tutorial.html#ixzz2dHtHghjo
	}

}
