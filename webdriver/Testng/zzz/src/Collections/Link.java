package Collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Link {
	public static void main(String[] args){
		// String is genrics we used in collection
		List<String> lst=new LinkedList<String>();
		lst.add("kiruba");
		lst.add("kiruba");
		lst.add("don");
		lst.add("");
		Iterator<String> it1=lst.iterator();
		System.out.println(it1.next());
		System.out.println(it1.next());
		System.out.println(it1.next());
		System.out.println("--------------");
		System.out.println("--------------");
		for(String name:lst){
			System.out.println(name);
		}
	}

}
