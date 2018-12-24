package final_finaly_finalize;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FinalKeyWordJava {

	class Parent1 {

		public final String s;

		public Parent1() {
			/**
			 * if you are not initialized the final varaible using constructor then it
			 * throws compile time exception.
			 * 
			 */

			s = "asfasf";/**
							 * we cannot re initialize the final variable.
							 */
			// s ="tetsttt";
		}

		public void method1() {
			System.out.println("Parent1 method1");
		}

		final void method2() {
			System.out.println("Parent 1 final method method2()");
		}
	}

	/**
	 * final class extends any other non final class but it does not allows any
	 * other class extends to final
	 * 
	 *
	 */
	final class finalClass extends Parent1 {

		public void method1() {
			System.out.println("final class final method");
		}
	}

	class child1 extends Parent1 {
		public void method1() {
			System.out.println("child1 class method1");
		}
	}

	/**
	 * @Override final void method2() {
	 * 
	 *           } we cannot override the final method in child class
	 *
	 */

	/**
	 * The finally keyword is used in association with a try/catch block and
	 * guarantees that a section of code will be executed, even if an exception is
	 * thrown. The finally block will be executed after the try and catch blocks,
	 * but before control transfers back to its origin.
	 * 
	 * @param args
	 */

	// class child2 extends finalClass // not possible

	public static void main(String args[]) {

		FinalKeyWordJava f = new FinalKeyWordJava();
		Parent1 p = f.new Parent1();
		p.method1();
		p.method2();

		try {
			System.out.println(10 / 0);
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} finally {
			System.out.println("finally method executed");
		}

		/**
		 * basically finally keyword used to resources deallocation like closing db
		 * connection and close the buffered reader after java 1.7onwards finally is
		 * optional it introduced try-with-resource Statement (ie) the resources which
		 * opened the try statement it automatically gets deallocated/closed
		 * 
		 * 
		 */
		String path = "/home/praveen/eclipse-workspace/Java8/src/final_finaly_finalize/readme.md";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String s;
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/**
		 * it close the resource in reverse order check the output
		 */

		try (demo demoObj = f.new demo();demo1 dmObj1 = f.new demo1()) {
			demoObj.show();
			dmObj1.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * if you want to use try-with-resource statement then we need implements
	 * Closeable or AutoCloseable interface
	 * 
	 * you need to provide the implementation for the close method
	 */
	class demo implements AutoCloseable {
		@Override
		public void close() throws Exception {
			System.out.println("close for demo");
		}

		public void show() {
			System.out.println("demo -- show");
		}
	}

	class demo1 implements Closeable {
		public void show() {
			System.out.println("demo1 -- show");
		}

		@Override
		public void close() throws IOException {
			System.out.println("demo1 -- close() ");
		}
	}

}
