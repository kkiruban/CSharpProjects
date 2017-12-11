package basicCoreJavaPrograms;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<String> hahset= new HashSet<String>();
		hahset.add("kiru");
		hahset.add("anand");
		hahset.add("kiru the don");
		hahset.add("don");

    System.out.println(hahset);
		 
		 Iterator<String> i=hahset.iterator();
//		 i.hasNext();
		 
		 while(i.hasNext()){
			 System.out.println(i.next());
		 }
	}

}
