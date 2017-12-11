package Methodoverloading;

class A{
	public int test1(int a){
		System.out.println("hi");
		return a;
		}
	public void test1(double b){
		System.out.println("hello");
	}
}
public class Methodoverloading1 {

	
	public static void main(String[] args) {
		// methodoverloading toatally  depending on the signature 
		A a=new A();
		a.test1(19);
	}

}
