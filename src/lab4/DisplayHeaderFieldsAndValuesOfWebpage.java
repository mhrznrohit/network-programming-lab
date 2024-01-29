//Name: Rohit Maharjam
//Roll no: 26
//Program to display all the header fields and values from a webpage response. 
package lab4;
import java.net.*;
import java.io.*;


public class DisplayHeaderFieldsAndValuesOfWebpage {

	public static void main(String[] args) {
		try { 
            URL url = new URL("https://divyagyan.edu.np"); 
            URLConnection urlConnection = url.openConnection(); 
            // retrieving the header fields                 
            for (int j=1; ; j++) { 
                String header = urlConnection.getHeaderField(j); 
                if(header == null)                         
                	break; 
                System.out.println(urlConnection.getHeaderFieldKey(j) + ": " + header); 
            }             
        } 
        catch (MalformedURLException e) { 
            System.out.println("Not a proper URL"); 
            System.out.println(e.getMessage()); 
        } 
        catch (IOException e) { 
            System.out.println(e.getMessage()); 
        } 

	}
}
