package MethodOverriding;

class A{
	public void test1(){
		System.out.println("kiruba the don");
	}
}
class B extends A{
	public void test1(){
		System.out.println("method-overriding==kiruba the monster");
	}
}
public class Overriding1 {

	
	public static void main(String[] args) {
		B b=new B();
		b.test1();
		A a=new A();
		a.test1();
	}

}
