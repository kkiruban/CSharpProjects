package Pratice;

class Dog{
	int size;
	Dog(int size){
		this.size=size;
	}
	public String tostring(){
		
		return ""+size ;
		
	}
}

public class Run2 {

	public static void main(String[] args) {
		
		Dog d1=new Dog(20);
		Dog d2=new Dog(20);
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d1.tostring());
		System.out.println(d2);
		//System.out.println((d1==d2));
		//System.out.println(d1.equals(d2));
		
	}

}
