package interfaces.functional;

public class FunctionalEx1 {
	
	

	public static void main(String args[]) {
		Runnable runable = () -> {
			System.out.println("New Thread Created");
		};
		new Thread(runable).start();

		FunctionalIntEx1 add = (int a,int b) -> a+b;
		FunctionalIntEx1 mull = (int a,int b) -> a*b;
		
		
		System.out.println(add.print(add.operate(1,2)));
		System.out.println(add.print(mull.operate(1,2)));
		

	}
}
