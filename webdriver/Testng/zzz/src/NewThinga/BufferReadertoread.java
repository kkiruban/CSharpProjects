package NewThinga;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferReadertoread {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\kiruba\\Desktop\\kiru.txt")));
		String expectedname="kiruba";
		String contents=br.readLine();
		System.out.println(contents);
		if(contents.contains(expectedname)){
			System.out.println("name is present");
		}else{
			System.out.println("name is not present");
		}
		String[] arr=contents.split(" ");
		for(int i=0;i<=arr.length-1;i++){
			System.out.println(arr[i]);
		}
		System.out.println(arr[0]);
				
	}

}
