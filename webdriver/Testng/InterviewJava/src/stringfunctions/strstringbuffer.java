package stringfunctions;



public class strstringbuffer {

	public static void main(String[] args) {
		
        	StringBuffer str= new StringBuffer("kirubanand");
        	str.append(" ramasamy");
        	System.out.println(str);
        	
        	str.deleteCharAt(9);
        	
        	System.out.println(str);
        	
        	System.out.println(str.reverse());
		
	}

}
