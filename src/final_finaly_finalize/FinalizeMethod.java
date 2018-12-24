package final_finaly_finalize;

public class FinalizeMethod {

	@Override
	protected void finalize() {
		System.out.println("FinalizeMethod -- finalize()");
	}

	class A {
		protected void show() {
			System.out.println("FinalizeMethod - A-- show()");
		}
		
		protected void finalize() {
			System.out.println("FinalizeMethod - A-- finalize()");
		}
	}

	class B extends A {
		
		@Override
		protected void show() {
			System.out.println("FinalizeMethod - B-- show()");
		}
		
		@Override
		protected void finalize() {
			//super.finalize();
			System.out.println("FinalizeMethod - B-- finalize()");
		}
	}

	public static void main(String args[]) {
		FinalizeMethod f = new FinalizeMethod();
		/**
		 * you should manually deallocate the object, then gc automatically calls
		 * finalize() method of the class
		 * 
		 * there is no guarantee about the time when finalize when called
		 * 
		 */
		f = null;

		/**
		 * checking inheritance
		 */
		f = new FinalizeMethod();
		B b = f.new B();
		b.show();
		b = null;

		System.gc();

	}

}
