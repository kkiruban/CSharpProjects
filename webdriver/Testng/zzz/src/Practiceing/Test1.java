package Practiceing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\kiruba\\Desktop\\kiru.txt")));
		String content=br.readLine();
		System.out.println(content);
		String expectedname="kiruba";
		if(content.contains(expectedname)){
			System.out.println("given string name is present in file");
		}else{
			System.out.println("given string name is not present ");
		}
			
	}

}
