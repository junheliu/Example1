import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountChar {

	public static void main(String[] args) {
		
		int count = 0;
		char c = args[0].charAt(0);
		

		Path file = Paths.get(System.getProperty("user.home"), "projects", "file", "sample.txt");
		System.out.println("file path is: " + file + "\n");
		
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		        System.out.println(line);
		        count += countLine(line, c);
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		
		System.out.println("The number of character " + c + " is " + count);
	}
	
	public static int countLine(String line, char c)
	{
		int counter = 0;
		
		for (int i=0; i<line.length(); ++i)
			if (line.charAt(i) == c)
				counter ++;
		return counter;
			
	}

}
