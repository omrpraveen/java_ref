package interfaces.classes;

/**
 * 
 * it is does not specify the access modifier in the classes.
 * 
 *
 */
class defaultClass {

	String classname;

	defaultClass(String classname) {
		this.classname = classname;
	}

	public void printmessage() {
		System.out.println("Default Classes => message");
	}

	static class Ex4 {
		public void printMessage() {
			// System.out.println("Parent=>"+classname);//compile time exception
			// when you declared child class as a static then you will not
			// able to access the parent proberties inside the child class
			System.out.println("Ex 4 => message");
		}

		private class Ex5 {
			public void printMessage() {
				System.out.println("Ex 5 => message");
			}
		}
	}

}

/*
 * This is an public class here public is an modifier so java we have default
 * public protected private
 * 
 * we can use static class with the help of java inner classes
 * 
 * 
 */
public class Ex1 extends defaultClass {

	Ex1(String classname) {
		super(classname);
	}

	private class Ex2 {
		public void printMessage() {
			System.out.println("Ex 2 => message");
			System.out.println("Parent=>" + classname);
		}

		public class Ex3 {
			public void printMessage() {
				System.out.println("Ex 3 => message");
			}
		}
	}

	public static class Ex4 {
		public void printMessage() {
			System.out.println("Ex 4 => message");
		}

		private class Ex5 {
			public void printMessage() {
				System.out.println("Ex 5 => message");
			}
		}

	}

	public static void main(String args[]) {
		Ex1 ex1 = new Ex1("Test");
		Ex1.Ex2 ex2 = ex1.new Ex2();
		System.out.println(ex2.toString());
		ex2.printMessage();
		Ex1.Ex2.Ex3 ex3 = ex2.new Ex3();
		ex3.printMessage();

		Ex1.Ex4 ex4 = new Ex1.Ex4();
		ex4.printMessage();

		Ex1.Ex4.Ex5 ex5 = ex4.new Ex5();
		ex5.printMessage();
	}

}
