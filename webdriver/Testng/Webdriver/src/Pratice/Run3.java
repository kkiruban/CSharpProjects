package Pratice;

class B{
	public String tostring(){
		System.out.println("tostring is overrided");
		return "object of B";
	}
}

public class Run3 {

	
	public static void main(String[] args) {
		B b1=new B();
		System.out.println(b1.tostring());
		System.out.println(b1);
		

	}

}
