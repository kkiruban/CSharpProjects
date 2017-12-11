package AdvancedJavaprograms;

public class StringReplace {

	public static void main(String[] args) {
		
		
		//replace string
		String str="kirubanand rama";
		
		String replacestring=str.replaceAll("rama", "ramasamy");
		
		System.out.println(replacestring);
		
		//replace char
				String chr="kirubanand rama";
				
				String replacechar=chr.replace("a", "e");
				
				System.out.println(replacechar);
				
		//split string
				String spl="kiruba.nandrama.samy";
				String[] words=spl.split("\\.");
				for(String w:words) {
					
					System.out.println(w);
				}

	}

}
