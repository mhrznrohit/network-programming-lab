//Name: Rohit Maharjan
//Roll: 26
//Program to download a web page of a given web address 
package lab2;
import java.net.URL;
import java.io.*;
import java.net.MalformedURLException;

public class download {
	public static void main(String[] args) throws Exception {
		URL u = new URL("http://www.tu.edu.np/");
		try {
			BufferedReader readr = new BufferedReader(new InputStreamReader(u.openStream()));
			BufferedWriter writer = new BufferedWriter(new FileWriter("Download.html"));
			String line;
            while ((line = readr.readLine()) != null) {
                writer.write(line);
            }
  
            readr.close();
            writer.close();
            System.out.println("Successfully Downloaded.");
        }
  
        catch (MalformedURLException mue) {
            System.out.println("Malformed URL Exception raised");
        
		}
	}	
}
