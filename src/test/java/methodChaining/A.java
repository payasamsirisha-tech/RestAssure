package methodChaining;

public class A {
	
	//we can do for static methods also
	public A a() {
		System.out.println("executing method a");
		return new A();
	}
	public A b() {
		System.out.println("executing method b");
		return new A();
	}
	public B c() {
		System.out.println("executing method c");
		return new B();
	}

}
