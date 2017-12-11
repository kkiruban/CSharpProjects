package intervviewjava;

import java.util.HashMap;
import java.util.Map;

//occurance of character in a string
public class occurance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "aaabbbccc";

		Map<Character, Integer> stringHash = new HashMap<Character, Integer>();
		for (char ch : s.toCharArray())
		    stringHash.put(ch, stringHash.containsKey(ch) ? (stringHash.get(ch) + 1) : 1);

		System.out.println(stringHash);
		// output: "{a=3, b=3, c=3}"

	}

}
