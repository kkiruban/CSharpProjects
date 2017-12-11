package basicCoreJavaPrograms;

import java.util.ArrayList;

public class ArrayListSample {

	public static void main(String[] args) {
		
		ArrayList<String> refarray = new ArrayList<String>();
		
		refarray.add("kiruba");
		refarray.add("java");
		refarray.add("monkey");
		refarray.add(0, "kiru the don");
		System.out.println(refarray);
		
		refarray.remove(3);
		System.out.println(refarray);

		System.out.println(refarray.indexOf("kiruba"));
		System.out.println(refarray.size());
		System.out.println(refarray.isEmpty());
	}

}
