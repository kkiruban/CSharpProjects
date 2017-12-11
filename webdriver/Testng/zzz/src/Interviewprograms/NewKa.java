package Interviewprograms;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;

import org.apache.poi.hssf.usermodel.examples.SplitAndFreezePanes;

public class NewKa {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\kiruba\\Desktop\\kiru.txt")));
      String contents = br.readLine();
      System.out.println(contents);
       String[] arr=contents.split(" ");
       System.out.println(arr[3]);
       int count=0;
      if(contents.contains("kiruba")){
      System.out.println("name is present");
        count=count+1;
        System.out.println(count);
	}
      else{
    	  System.out.println("name is not present ");
      }

     	}
	}
