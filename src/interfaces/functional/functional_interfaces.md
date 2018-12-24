Functional Interface:
	
	a functional interface is an interface it contains only one abstract method and any number of default methods.
	
	we can use @FunctionalInterface to mention the functional interface. there is no need to mention this annotations compiler implicitly understand the functional interface.
		
	if you declare more than one method in a interface then it throws compile time error.
			
	lambda expression can be used to represent the instance of a functional interface. 
	
	Default functional interfaces are:
		Runnable, ActionListener, Comparable.
		
	Ex:
	
		@FunctionalInterface
		public interface FunctionalIntEx1 {
			int operate(int a, int b);
			default String print(int a) {
				return "The Result is "+a;
			}
		}
		
		FunctionalIntEx1 add = (int a,int b) -> a+b;
		FunctionalIntEx1 mull = (int a,int b) -> a*b;
		System.out.println(add.print(add.operate(1,2)));
		System.out.println(add.print(mull.operate(1,2)));
		
		Runnable runable = () -> {System.out.println("New Thread Created");};
		new Thread(runable).start();
		
java.util.function package contains many built in interfaces 
		
1. Predict:
	
	it has an a abstract method test which will return boolean as result.
		it has
			1.test(T) :
				it is an abstract method that test which will return boolean as result.
					Ex:
						Predicate<Integer> isGreaterThan0 = i -> i>0;
						System.out.println(isGreaterThan0.test(-10));
						System.out.println(isGreaterThan0.test(10));
			2.and(Predicate<T>) :
				it is an default method. Returns a composed predicate that represents a short-circuiting logical AND of this predicate and another.
				Ex:
					Predicate<Integer> isGreaterThan0 = i -> i>0;
					Predicate<Integer> isGreaterThan10 = i -> i>10;
					System.out.println(isGreaterThan0.and(isGreaterThan10).test(10));
					System.out.println(isGreaterThan0.and(isGreaterThan10).test(11));
			3. negate():
				returns a predicate that represents logical negation of the predicate
				Ex:
					Predicate<Integer> isGreaterThan0 = i -> i>0;
					System.out.println(isGreaterThan0.negate().test(-10));		
			
			4.or(Predicate<T>) :
				it is an default method. Returns a composed predicate that represents a short-circuiting logical OR of this predicate and another.
				Ex:
					Predicate<Integer> isGreaterThan0 = i -> i>0;
					Predicate<Integer> isGreaterThan10 = i -> i>10;
					System.out.println(isGreaterThan0.or(isGreaterThan10).test(-10));
					System.out.println(isGreaterThan0.or(isGreaterThan10).test(10));
			5.isEqual(Object obj)
				returns a predicate if two arguments are equal
				Ex:
					String s1 = new String("test");
					String s2= new String("test");
					Predicate<String> isEqual = Predicate.isEqual(s1);
					System.out.println(isEqual.test(s2));
	More Classes:
		1. LongPredicate : it has one abstract method test(long ) and it has following default methods. 
			and(LongPredicate other) , negate(), 	or(LongPredicate other)
		2. BiPredicate<T,U> :it accept two predicates one abstract method test(T t,U t) and it has following default methods. 
			and(BiPredicate other) , negate(), 	or(BiPredicate other) 
		3. DoublePredicate : it has one abstract method test(double ) and it has following default methods. 
			and(DoublePredicate other) , negate(), 	or(DoublePredicate other)
		4. IntPredicate : it has one abstract method test(int ) and it has following default methods. 
			and(IntPredicate other) , negate(), 	or(IntPredicate other)
			
		 
2. Consumer:
	
	it can be used where on object needs to be consumed. i.e it takes an a input and some operations is to be performed on the object while returning any result.
	accept(T): void 
		 performs the operations on the given argument.
		 
	andThen(Consumer<T>) : Consumer<T>
		return composed consumer that performs.
		
	More Consumer Class are:

		    IntConsumer having one abstract method ' accept(int)' and one default method ' default IntConsumer andThen(IntConsumer after)'
		    DoubleConsumer having one abstract method ' accept(double)' and one default method ' default DoubleConsumer andThen(DoubleConsumer after)'
		    LongConsumer having one abstract method ' accept(long)' and one default method ' default LongConsumer andThen(LongConsumer after)'
		    
3. Supplier:
		
		it does not accpet argumets but it returns some value by calling its get() method
		
		get():
			it returns some object.
			
		More Supplier Classes are:
			IntSupplier having one abstract method getAsInt()
			LongSupplier having one abstract method getAsLong()
			DoubleSupplier having one abstract method getAsDouble()
			BooleanSupplier having one abstract method getAsBoolean()

4. Functional:
	
	The primary purpose for which Functional<T,R> is used for mapping scenerio, here functional interface takes on a input T and generate corresponding output R.
	it has one abstract method  apply()(R apply(T t)) it has input T and convert into R.
	 
	
	
						
			
			
				
				
				
				
				
			
			
		 
			
	
 
