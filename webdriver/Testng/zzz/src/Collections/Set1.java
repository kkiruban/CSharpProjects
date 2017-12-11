package Collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Set1 {
	public static void main(String[] args){
		Set<String> mycolor=new HashSet<String>();
		mycolor.add("red");
		mycolor.add("yellow");
		mycolor.add("green");
		mycolor.add("red");
		Iterator<String> it= mycolor.iterator();
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		
		System.out.println("-------------------");
		System.out.println("-------------------");
		for(String value: mycolor){
			System.out.println(value);
		}
		System.out.println("-----------");
		System.out.println("---------------");
		
		Set<Integer> nos=new HashSet<Integer>();
		  nos.add(10);
		  nos.add(20);
		  nos.add(30);
		  nos.add(0);
		  Iterator<Integer> it2=nos.iterator();
		  System.out.println(it2.next());
		  System.out.println(it2.next());
		  System.out.println(it2.next());
		  System.out.println(it2.next());
		  System.out.println("------------");
		  System.out.println("--------------");
		  for(Integer value2:nos){
			  System.out.println(value2);
	
		  }
		  
	}
	

}
