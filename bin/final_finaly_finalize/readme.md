final keyword:

	 final variable in final variable the value of the variable cannot be changed
	 once initialized.
	 
	 you can initialize the values to final variable using constructor also.
	 
	 final method if the method is final means it cannot be override final class
	 
	 if we declared any class as a final means then the class does not have any sub class it is not possible to inherit if the class declared as final then 
	 
	 all the methods are final
	 
	 

Key Differences Between Static and Final in Java
	  
	  1. The static keyword is applicable to a nested static class, variables, methods and blocks. On the other hand, final keyword is applicable to class methods and variables. 
	  
	  2. Static variable can be initialized any time whereas, a final variable must be initialized at the time of declaration. 
	  
	  3. A static variable can be reinitialized whereas, once initialized a final variable can never be	 reinitialized. 
	  
	  4.A static method can access the static member of the class and can only be invoked by other static methods. On the other hand, the final method can never be inherited by any class. 
	  
	  5. Static block is used to initialize the static variables whereas, final keyword does not support any block.
	  
	  6. final method if the method is final means it cannot be override final class if we declared any class as a final means then the class does not have any sub class it is not possible to inherit if the class declared as final then all the methods are final
	  
finally:
	
	The finally keyword is used in association with a try/catch block and guarantees that a section of code will be executed, even if an exception is thrown.
	The finally block will be executed after the try and catch blocks, but before control transfers back to its origin.
	
	basically finally method used to deallocating or closing the system resources like db connection and other system resources,
	
	it is mandatory at the time of JDK1.6 after 1.7 it is optional they introduced try with resource statment.
	
Try-with-resource-statement:
	
	in java ARM (Automatic resource management) uses the try with resource statment that declares one or more resources and ensures that resource is closed at the end of the statement
	Resource that we use in try-with-resource must be subtypes of AutoCloseable to avoid compile time error.
	The Resources are closed in reversed order
	
finalize():
	
	it is a method that the GC calls just before the deletion of the objects which is eligible for gc.
	
	it is perform clean up activity means closing the resource, or connnections associated with that objects.
	
	since java.lang.Object contains finalize() method, so every class contains this finalize method with empty implementations.
	
	it is not reserved word so we can call explicitly.
	
	There is no guarantee about the time when finalize is called.
	
	JVM does not ignore all execeptions while executing finalize method, but it ignores only unchecked exceptions. if the corresponding catch block is there then JVM won't ignore and corresponding catch block will be executed.
	
	we can override the finalize method using child class. but you should call finalize method in super class. it will never called automatically. 
	
		
