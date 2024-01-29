//Name: Rohit Maharjan
//Roll: 26
//Program to download a object
package lab2;
import java.net.*;
import java.io.*;
import java.net.MalformedURLException;


public class DownloadObject {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		URL u = new URL("http://www.hamrobazaar.com/");
		try {
			BufferedReader readr = new BufferedReader(new InputStreamReader(u.openStream()));
			BufferedWriter writer = new BufferedWriter(new FileWriter("Downloader.html"));
			String line;
            while ((line = readr.readLine()) != null) {
                writer.write(line);
            }
  
            readr.close();
            writer.close();
            System.out.println("Successfully Downloaded.");
        }
  
        // Exceptions
        catch (MalformedURLException mue) {
            System.out.println("Malformed URL Exception raised");
        
		}
	}
}
