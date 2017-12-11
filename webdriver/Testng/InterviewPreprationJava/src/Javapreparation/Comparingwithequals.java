package Javapreparation;
class C{
	int i;
	C(int i){
		this.i=i;
	}
	public String tostring(){
		return ""+i;
	}
}
public class Comparingwithequals {

	
	public static void main(String[] args) {
		C c1 = new C(10);
		C c2 = new C(10);
		System.out.println(c1==c2);
		System.out.println(c1.equals(c2));
		System.out.println(c1);
		System.out.println(c2);
	}

}
