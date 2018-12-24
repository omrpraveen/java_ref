Concurrency:
	package - java.util.concurrency
	
	in concurrent programming there are two basic units of execution
		1. Threads,
		2. Process
	
1. Process:
	
	a process is a self contained execution environment.
	it has a complete, private set of basic run time resources. each process has its own memory space.
	
	most implementation of jvm run as a single process.
	
	the classes such as Process and other related classes defined in the java.lang package provide siginificant support.
	
	These classes are used to gather info about and implement runtime process.
	
	
	Process:
		it is an abstract class defined in java.lang that encapsulates the runtime information of a program in execution.
		
		Methods provided by the Process is used to perform input, output waiting for the process to complete, checking exit status of the process and destroying the process
		it extends object
		
		it is used primarily as a superclass of the type of object created by exec() in the Runtime class.
		
		ProcessBuilder.start() and Runtime.getRuntime.exec() methods creates a native process and return instance of a class Process.
		
		ProcessBuilder.start() is the most preferred way to create a process.
		
	Methods are:
		1. void destroy() & destroyForcely() : kill the subprocess.
		2.getInputStream(), getOutputStream() and getErrorStream() 
			the process crated by the exec method does not own a console. Therefore, redirecting its input, output and error in the standared file is ruld out. Instead, it redirects to the parent process. if need be, we can access them via streams obtained using the above methos.
			
		3. exitValue() : exit code returned from the process executed.
		4. isAlive() : to check the process is alive
			
		
	
		
	
	Runtime:
	
		Every java app has a single instance of class Runtime, that allows the application to interface with the environment in which the application is running.
		
		Runtime encapsulates the runtime env of the program.
		
		This class cannot be instantiated, but we can get a reference to the Runtime of the currently running program with the help of the static method called Runtime.getRuntime().
		
		There are several methods are defined in the runtime class such as number of processors availabe, memory  min and max, loading native library. call gc and so forth.
		
	
	
	ProcessBuilder:
		
		This is an auxiliary class for the process and is instantiated to manage a collection of process attributes.
		we can invoke the start method to create a new process with the attributes 
		repeated calls to the start method would create a new process with the same attributes.
		
		it is not synchronozed and it not thread safe to access the instance of this class through multiple threads.
		it treated first one as command and reamining are the parameters
		
	ProcessHandle :
		java 9 introducess java.lang.ProcessHandle interface with its nested Info interface
		
		this can help us to 
			identify the child or descendent processes,
			obtains the Process PID,
			info about the Process,
			etc..
		
		
    Stream<ProcessHandle> children()
    Stream<ProcessHandle> descendants()
    long getPid()
    ProcessHandle.Info info()
    CompletableFuture<Process> onExit()
    boolean supportsNormalTermination()
    ProcessHandle toHandle()
		
			
		
		
		
	
	
	
	
	
2. Threads:
	
	it is a lightweight process.
	 
	
	

		
