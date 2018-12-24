package concurrency;

import java.io.IOException;

public class Java_Runtime {

	static class Message extends Thread {
		public void run() {
			System.out.println("Program exiting");
		}
	}

	public static void main(String args[]) {
		try {

			/**
			 * This will return the current instance of runtime associated with the java app
			 */
			Runtime rn = Runtime.getRuntime();
			rn.traceInstructions(true);
			/**
			 * This method returns the amount of free memory
			 */
			System.out.println(rn.freeMemory());
			/**
			 * returns total memory in the jvm
			 */
			System.out.println(Runtime.getRuntime().totalMemory());

			/**
			 * executes given command in separate process. throws: SecuriyException : does
			 * not allow to create the sub process IOException NullPointerException :
			 * command is null IllegalArgumentException : command is empty
			 * 
			 */
			
			//rn.exec("gedit");
			
			/**
			 * JVM Shutdown hook 
			 * 	
			 * shutdown hooks are a special construct that allow developers to plug in a
			 * piece of code to be executed. when the JVM is shutting down.
			 * 
			 * it runs the two cases.
			 * 	1. The program exists normally, or we call System.exit() method
			 * to determine te program.	
			 *  2. User interupts such as Ctrl+C
			 * 	
			 * Important points,
			 * 	1. we can add multiple shutdown hooks
			 * 	2. it is not initialized by threads, They start when
			 * 		JVM shutdown triggers.
			 * 	3. we cannot determine the order in which shutdown hooks will execute,
			 * 		just like a thread executions.
			 * 	4. All un invoked finalizers are executed. if finalization-on-exit has been enable.
			 * 	5. There is no guarantee that shutdown hooks will execute. such as 
			 * 		system crash, kill command etc. 
			 * 	
			 * 
			 */
			
			/**
			 * This method used to add shoutdown hook
			 */
			Message ms = new Message(); 
			
			rn.addShutdownHook(ms);
			
			//System.out.println("Waiting for 5 seconds");
			
			//Thread.sleep(5000);
			
			/**
			 * removeShutdownHook is used to remove the shutdown hook
			 */
			
			//rn.removeShutdownHook(ms);
			/**
			 * availableProcessors()
			 * this method returns the number of processors available in JVM
			 * like RAM
			 */
			System.out.println(rn.availableProcessors());
			
			/**
			 * eixt(int status)
			 * 	This method terminates the currently running jvm 
			 * it accepts two status as a agrument
			 * (ie) zero and nonzero termination
			 * zero - 0 - means successful termination
			 * non zero - (1 or -1) - abnormal termination
			 * 
			 */
			
			//rn.exit(0);
			/**
			 * it enable or disables tracing of instructions, if it 
			 * is true then JVM emits debugging information 
			 */
			rn.traceInstructions(true);
			System.out.println("Enabled");
			//rn.traceInstructions(false);
			//System.out.println("disabled");
			
			/**
			 * this method enables or disable tracing of method calls.
			 * it will suggests that the JVM emit debugging info for each
			 * method in the VM as it is called
			 */
			rn.traceMethodCalls(true);
			
			/**
			 * This method loads the dynamic library with 
			 * the specified library name.
			 * 
			 * A file containing code is loaded from the local system
			 * from a place where library files are conventinally obtained.
			 * 
			 * it throws,
			 * 	UnstatisfiedLinkError : if the library does not exist.
			 * 	NullPointerException : if libname is null.
			 * 	SecurityException : if checkLink method doesn't allow
			 * 		loading of the specified dynamic library.
			 * 
			 * 
			 * 
			 */
		      //Runtime.getRuntime().loadLibrary("C:/Windows/System32/crypt32.dll");
			/**
			 * void gc() - if we calling this method suggest that the JVM expends efforts
			 * towards recyling the unused objects in order to make the memory they currently occupy
			 *  
			 */
			
			rn.gc();
			
			/**
			 * void runFinalizaton()
			 * 	this method runs the finalization methods of any objects
			 * pending finalization
			 * 
			 */
			rn.runFinalization();
			
			/**
			 * long maxMemory()
			 * 		returns the maximum amount of memory that the JVM will attempt to use
			 * if there is no inherent limit then the value Long.MAX_VALUE will be returned.
			 */
			
			System.out.println(rn.maxMemory());
			
			/**
			 * halt(int status)
			 * 		this method forcibly terminates the currently runnig jvm
			 */
			
			
			
			
			
		} catch (SecurityException e) {
			/**
			 * when security manager does not allow to create subprocess.
			 */
			e.printStackTrace();
		}catch (NullPointerException e) {
			/**
			 * when execution command is empty
			 */
			e.printStackTrace();
		}/*catch (IOException e) {
			*//**
			 * if an I/O error occurs
			 *//*
			e.printStackTrace();
		}*/catch (IllegalArgumentException e) {
			/**
			 * when excecution command is empty
			 */
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void finalize() {
		System.out.println("finalize method called");
	}
}
