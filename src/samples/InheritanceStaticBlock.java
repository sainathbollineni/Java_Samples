package samples;

class A11 {
	static {
		System.out.println("THIRD");
	}
}

class B11 extends A11 {
	static {
		System.out.println("SECOND");
	}
}

class C11 extends B11 {
	static {
		System.out.println("FIRST");
	}
}

public class InheritanceStaticBlock {
	public static void main(String[] args) {
		
		A11 a = new C11();
	}
}