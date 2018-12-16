package samples;

public class ConstructorStaticAndInstanceBlocks {

	public static void main(String[] args) {

		A a = new A();

		System.out.println("****************************");

		B b = new B();

		System.out.println("***************************");

		A a1 = new B();

		System.out.println("***************************");
	}
}

class A {

	{
		System.out.println("Instance Block of A");
	}

	A() {
		System.out.println("Default Constructor of A");
	}

	static {
		System.out.println("Static Block of A");
	}
}

class B extends A {

	{
		System.out.println("Instance Block of B");
	}

	B() {
		System.out.println("Default Constructor of B");
	}

	static {
		System.out.println("Static Block of B");
	}
}
