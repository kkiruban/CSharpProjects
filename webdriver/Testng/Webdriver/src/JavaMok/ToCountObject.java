package JavaMok;
class abc
{
static int count;
abc()
{
count++;
System.out.println("objects="+count);
}
}



public class ToCountObject {

	
	public static void main(String[] args) {
		
		abc a1 = new abc();
		abc a2 = new abc();
		abc a3=new abc();
		}
	}
		

	


