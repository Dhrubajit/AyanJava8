package methodhiding;

public class UnderstandMethodHiding {

	public static void main(String args[] ) {
		Sample sub = new Sample();
		Demo sup = new Demo();
		Demo supsub = new Sample();
		sub.demoMethod();
		sup.demoMethod();
		supsub.demoMethod();
		
	}
}


class Demo{
	int i;
	public static void demoMethod() {
		System.out.println("method of super class");
	}
}
class Sample extends Demo {
	int i;
	public static void demoMethod() {
		System.out.println("method of sub class");
	}

}