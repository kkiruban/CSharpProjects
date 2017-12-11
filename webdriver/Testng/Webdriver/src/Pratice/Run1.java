package Pratice;

//example for == and equals method
class D{
	int i;
	 D(int i) {
	  this.i=i;
	}
	public boolean equals(Object o){
		int a=this.i;
		int b=((D)o).i;
		return(a==b);
		
	}
}
public class Run1 {

	
	public static void main(String[] args) {
		D d1=new D(10);
		D d2=new D(10);
		System.out.println("comparing using =="+(d1==d2));//comparing address
		System.out.println("comparing using equals="+d1.equals(d2));//comparing member value
		
	}

}
