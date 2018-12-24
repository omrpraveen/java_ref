package concurrency;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessBuilderEx {

	public static void main(String args[]) {

		try {

			getInfo();

			redirectToFileTest();

			filterProcessesTest();
			
			startSeveralProcesses();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This is an example for processbuilder info interfaces
	 * 
	 * @throws IOException
	 */
	public static void getInfo() throws IOException {

		ProcessBuilder pb = new ProcessBuilder("echo", "Hello World!");
		String na = "<not available>";
		Process p = pb.start();
		ProcessHandle.Info info = p.info();
		System.out.printf("Process ID: %s%n", p.pid());
		System.out.printf("Command name: %s%n", info.command().orElse(na));
		System.out.printf("Command line: %s%n", info.commandLine().orElse(na));

		System.out.printf("Start time: %s%n",
				info.startInstant().map(i -> i.atZone(ZoneId.systemDefault()).toLocalDateTime().toString()).orElse(na));

		System.out.printf("Arguments: %s%n",
				info.arguments().map(a -> Stream.of(a).collect(Collectors.joining(" "))).orElse(na));

		System.out.printf("User: %s%n", info.user().orElse(na));
	}

	/**
	 * Redirecting output from a process If java create a sub process then it does
	 * not have any stdin and stdout or stderrors they transfers to the parent
	 * terminal or some others
	 * 
	 * a process writes standared output and standard errors to pipes. in our
	 * application we can access these pipes through the input,output,error streams
	 * 
	 * in below programs outputs of the commands is redirect to out.tmp it redirects
	 * stderror to the stderror of the invoking process. Redirect.INHERIT - I/O
	 * source and destination is the same as that of the current process.
	 * 
	 * inheritIO() - is equivalent to
	 * redirectInput(redirect.INHERIT).redirectOUtput(Redirect.INHERIT)
	 * 
	 * 
	 */

	public static void redirectToFileTest() throws IOException, InterruptedException {
		File outFile = new File("out.tmp");
		Process p = new ProcessBuilder("ls", "-la").redirectOutput(outFile).redirectError(Redirect.INHERIT).start();
		int status = p.waitFor();
		if (status == 0) {
			p = new ProcessBuilder("cat", outFile.toString()).inheritIO().start();
			p.waitFor();
		}
	}

	/**
	 * filtering process with streams
	 * 
	 * 
	 */
	private static void filterProcessesTest() {
		Optional<String> currUser = ProcessHandle.current().info().user();
		ProcessHandle.allProcesses().filter(p1 -> p1.info().user().equals(currUser)).sorted()
				.collect(Collectors.toList()).forEach(x -> showProcess(x));

	}

	private static void showProcess(ProcessHandle ph) {
		ProcessHandle.Info info = ph.info();
		System.out.printf("pid: %d, user: %s, cmd: %s%n", ph.pid(), info.user().orElse("none"),
				info.command().orElse("none"));
	}

	/**
	 * handling process when they terminate with the onExit method
	 */
	static void startSeveralProcesses()
			throws InterruptedException {
		List<ProcessBuilder> pBList = new ArrayList<>();
		pBList.add(new ProcessBuilder("/bin/sh", "-c", "grep -c \"java\" *"));
		pBList.add(new ProcessBuilder("/bin/sh", "-c", "grep -c \"Process\" *"));
		pBList.add(new ProcessBuilder("/bin/sh", "-c", "grep -c \"onExit\" *"));
		
		System.out.println("Number of processes: " + pBList.size());
		pBList.stream().forEach(pb -> {
			try {
				Process p = pb.start();
				System.out.printf("Start %d, %s%n", p.pid(), p.info().commandLine().orElse("<na>"));
				p.onExit().thenAccept(ProcessBuilderEx::printGrepResults);
			} catch (IOException e) {
				System.err.println("Exception caught");
				e.printStackTrace();
			}
		});
	}

	static void printGrepResults(Process p) {
		System.out.printf("Exit %d, status %d%n%s%n%n", p.pid(), p.exitValue(), output(p.getInputStream()));
	}

	private static String output(InputStream inputStream) {
		String s = "";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			s = br.lines().collect(Collectors.joining(System.getProperty("line.separator")));
		} catch (IOException e) {
			System.err.println("Caught IOException");
			e.printStackTrace();
		}
		return s;
	}

}
