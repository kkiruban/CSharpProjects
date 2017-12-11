package NewThinga;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SplitArray {

	
	public static void main(String[] args) throws IOException {
		File f=new File("C:\\Users\\kiruba\\Desktop\\minds.txt");
		try(FileInputStream fis=new FileInputStream(f)){
//			int str=fis.available();
//		      System.out.println(str);
			System.out.println("total words in the file:"+ fis.available());
			int content;
			while((content=fis.read())!=-1){
				System.out.print((char)content);
			}
		}catch(Throwable e){
			e.printStackTrace();
		}
		
	}

}
