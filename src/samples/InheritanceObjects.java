package samples;

public class InheritanceObjects {

	public static void main(String args[]) {

		ParentClass pc = new ParentClass();

		System.out.println(pc.name);

		pc.printClassName();
		pc.printStaticClassName();

		System.out.println("*****************************************");

		ChildClass cc = new ChildClass();

		System.out.println(cc.name);
		System.out.println(cc.department);
		cc.printClassName();
		cc.printClassName();

		System.out.println("*****************************************");

		ParentClass pc1 = new ChildClass();
		System.out.println(pc1.department);
		System.out.println(pc1.name);
		pc1.printClassName();

		pc1.printStaticClassName();

		System.out.println("*****************************************");

	}
}

class ParentClass {

	public String name = "parent";

	public String department = "Software";

	public void printClassName() {
		System.out.println("parentClass");
	}

	public static void printStaticClassName() {
		System.out.println("parentClass");
	}

}

class ChildClass extends ParentClass {

	public String name = "child";

	public void printClassName() {
		System.out.println("childClass");
	}

	public static void printStaticClassName() {
		System.out.println("childClass");
	}

}