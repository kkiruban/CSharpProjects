package basicCoreJavaPrograms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class StringFileOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
		    BufferedWriter out = new BufferedWriter(new FileWriter("D:\\javaStringFileOperatons\\test.txt"));
		    out.write("kiruba the great.\n learning java \n come on kiruba");  //Replace with the string 
		                                             //you are trying to write  
		    out.close();
		    FileReader fileReader = 
	                new FileReader("D:\\javaStringFileOperatons\\test.txt");
		    BufferedReader reader= new BufferedReader(fileReader);
		    
		    String line = null;
		    
		    while((line=reader.readLine()) !=null) {
		  
		    	System.out.print(line);
		    }
		    
		    reader.close();
		    
		}
		catch (IOException e)
		{
		    System.out.println("Exception ");

		}

//		try {
//			File file = new File("D:\\javaStringFileOperatons\\test.txt");
//			FileWriter fileWriter = new FileWriter(file);
//			fileWriter.write("This is ");
//			fileWriter.write("a test");
//			fileWriter.flush();
//			fileWriter.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}

}
