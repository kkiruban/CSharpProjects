package Interviewprograms;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringBufferInputStream;

public class File1 {

	
	public static void main(String[] args) throws IOException {
		
//		FileInputStream fis=new FileInputStream("C:\\Users\\kiruba\\Desktop\\kiru.txt");
		StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(
                new FileReader("C:\\Users\\kiruba\\Desktop\\kiru.txt"));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            System.out.println(fileData.append(readData));
            String expectedname="kiruba";
            StringBuffer actual=fileData.append(readData);
            
            	
            
        }
        reader.close();
//        BufferedReader br = new BufferedReader*new InputStreamReader(new FileInputStream("filename.txt")));
//        String contents = br.readLine();
//        BufferedReader br = new BufferedReader*new InputStreamReader(new FileInputStream("filename.txt")));
//        String contents = br.readLine();
//        if(contents.contains("kiruba")){
//        print("word is present");
        }
        
    	
	
	}


