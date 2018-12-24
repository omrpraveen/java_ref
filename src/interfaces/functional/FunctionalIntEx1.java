package interfaces.functional;

@FunctionalInterface
public interface FunctionalIntEx1 {
	
	int operate(int a, int b);
	
	default String print(int a) {
		return "The Result is "+a;
	}
}
