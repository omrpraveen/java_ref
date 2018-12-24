package interfaces.functional;

import java.util.function.Consumer;

public class ConsumerEx {
	
	public static void main(String args[]) {
		Consumer<String> consumer = (arg)->{
			System.out.println("Input is -> "+arg);
		};
		consumer.accept("Test");
		Consumer<String> consumer1 = (arg)->{
			System.out.println("Input is -> "+arg);
		};
		consumer1.andThen(consumer).accept("Test");
		
		
	}

}
