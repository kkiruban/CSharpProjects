package AdvancedJavaprograms;

public class WhyStringimmutableExample {

	public static void main(String[] args) {
		
		
		//Strings are immutable because once you create string object u cannot make changes to existing string object 

		//String is slow and consumes more memory when you concat too many strings because every time it creates new instance.
		
		//strings
		String s1="kirubanand";
		s1.concat("ramasamy");
		
		
		//stringbuffer is mutable
		//StringBuffer is fast and consumes less memory when you cancat strings.
		//string buffer
		StringBuffer strbuffer=new StringBuffer("kirubanand");
		strbuffer.append(" Ramasamy");
		
		System.out.println("String is immutable :" +s1);
		System.out.println("stringbuffer is mutable :" + strbuffer);
		
		
		
//		1)	StringBuffer is synchronized i.e. thread safe. It means two threads can't call the methods of StringBuffer simultaneously.	
//		StringBuilder is non-synchronized i.e. not thread safe. It means two threads can call the methods of StringBuilder simultaneously.
//		2)	StringBuffer is less efficient than StringBuilder.	
//		StringBuilder is more efficient than StringBuffer.
	}

}

