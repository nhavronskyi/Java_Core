package bin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Converter {
    // starter for renamer
	public void start() throws IOException {
        // class who declares command to start it in the console
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("bash", "-c", "./Converter.sh /Users/nhawronsky/Documents/Work/hector/");
		// start comand in the console
		Process process = processBuilder.start();
		// read a line from the console
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(process.getInputStream()));
		// empty line
		String line;
		// loop to show lines from the console
		while ((line = reader.readLine()) != null) {
			// function to show information
			System.out.println(line);
		}
    }
}
