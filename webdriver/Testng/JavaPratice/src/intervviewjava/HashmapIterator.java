package intervviewjava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashmapIterator {

	public static void main(String[] args) {
		
		//creates a empty hash map instance
		Map<String, Integer> map=new HashMap<>();
		
		//to insert the values into map
		map.put("ONE", 1);
		map.put("Two", 2);
		map.put("Three", 3);
		map.put("four", 4);
		map.put("five", 5);
		
		System.out.println(map.get("four"));
		
		Set<String> setofkeys=map.keySet();
		
		Iterator<String> it = setofkeys.iterator();
		
		while (it.hasNext()) {
			String key = (String) it.next();
			
			Integer value= (Integer)map.get(key);
			
			System.out.println("key: " + key +", value: " + value);
			
		}

	}

}
