package interfaces.functional;

import java.util.function.Supplier;

public class SupplierEx {
	
	public static void main(String args[]) {
		Supplier<String> supplier = ()->{
			return new String("New Stirng genereted");
		};
		System.out.println(supplier.get());
	}

}
