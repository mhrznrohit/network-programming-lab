//Name: Rohit Maharjam
//Roll no: 26
package lab4;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class DownloadWebpageUsingURLConnection {
	static int c;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try { 
		 	URL url = new URL("https://www.divyagyan.edu.np"); 
		            URLConnection urlConnection = url.openConnection(); 
		            InputStream inputStream = urlConnection.getInputStream();            
		            while ((c = inputStream.read()) != -1) 
		            { 
		                System.out.print((char) c); 
		            }         
		} 
		        catch (MalformedURLException e) {             
		System.out.println(e.getMessage()); 
		        } 
		        catch (IOException e) { 
		            System.out.println(e.getMessage()); 
		        } 

	}

}
