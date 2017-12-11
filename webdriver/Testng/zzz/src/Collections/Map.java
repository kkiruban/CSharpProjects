package Collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Map {
	public static void main(String[] args){
		
		HashMap<String, String> map1=new HashMap<String,String>();
		map1.put("kiruba", "vit");
		map1.put("rajesh", "mit");
		map1.put("belly", "chennai");
        System.out.println(map1.size());
        System.out.println(map1.values());
        System.out.println(map1.keySet());
        System.out.println("=================");
        Set<String> set= new HashSet<String>();
        Iterator<String> it=set.iterator();
        try{
        System.out.println(map1.put("don", it.next()));
        }
        catch(Throwable e){
        	e.printStackTrace();
        }
        finally{
        	System.out.println("kiruba the don");
        }
	}

}
