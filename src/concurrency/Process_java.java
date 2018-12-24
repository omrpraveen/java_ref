package concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.concurrent.TimeUnit;

public class Process_java {

	public static void main(String args[]) {
		try {
			Runtime rn = Runtime.getRuntime();
			Process process = rn.exec(new String[] {"cal","2019"});
			
			Process process1 = rn.exec(new String[] {"cal","202111"});
			process.waitFor(10, TimeUnit.SECONDS);
			System.out.println("get Input Stream");
			printStream(process.getInputStream());
			
			System.out.println("get Error Stream");
			printStream(process1.getErrorStream());
			
			System.out.println("get output stream");
			Process process2 = rn.exec("gedit");
			process2.waitFor(10, TimeUnit.SECONDS);
			Writer w = new OutputStreamWriter(process2.getOutputStream(),"UTF-8");
			w.write("Hai .....");
			System.out.println("output stream completed");
			
			
			

			ProcessBuilder pb = new ProcessBuilder("cal", "2022");
			Process p = pb.start();
			p.waitFor(10, TimeUnit.SECONDS);

			p.destroy();
			/**
			 * 0 - normal dermination oterwise - abnormal
			 */
			// System.out.println(p.waitFor());
			p.destroyForcibly();
			System.out.println(p.isAlive());
			
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void printStream(InputStream in) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}
}
