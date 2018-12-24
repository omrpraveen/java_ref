package interfaces.functional;

import java.util.function.Predicate;

public class PredicateEx1 {
	
	public static void main(String args[]) {
		
		Predicate<Integer> isGreaterThan0 = i -> i>0;
		System.out.println(isGreaterThan0.test(-10));
		System.out.println(isGreaterThan0.test(10));
		
		Predicate<Integer> isGreaterThan10 = i -> i>10;
		System.out.println(isGreaterThan0.and(isGreaterThan10).test(-10));
		System.out.println(isGreaterThan0.and(isGreaterThan10).test(11));
		
		System.out.println(isGreaterThan0.negate().test(-10));
		
		
		String s1 = new String("test");
		String s2= new String("test");
		Predicate<String> isEqual = Predicate.isEqual(s1);
		System.out.println(isEqual.test(s2));
		
		
		
	}

}
