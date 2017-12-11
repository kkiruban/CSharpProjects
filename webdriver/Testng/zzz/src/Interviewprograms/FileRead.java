package Interviewprograms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileRead {

	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		File file1=new File("C:\\Users\\kiruba\\Desktop\\kiru.txt");
		
		try(FileInputStream fis=new FileInputStream(file1)){
			System.out.println(fis.available());
			System.out.println("hai");
			int content;
			while((content=fis.read())!=-1){
				System.out.print((char)content);
				
				
			   }
			}
		catch(Throwable e){
			e.printStackTrace();
		}
		
		}

}
