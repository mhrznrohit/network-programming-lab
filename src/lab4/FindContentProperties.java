//Name: Rohit Maharjam
//Roll no: 26
//Program to find out the content type, content length and last modified and access date of a URL. 

package lab4;
import java.net.*;
import java.io.*;
import java.util.*;
public class FindContentProperties {
	public static void main(String[] args) {
		try { 
            URL url = new URL("https://www.divyagyan.edu.np"); 
            URLConnection urlConnection = url.openConnection(); 
 
            long date = urlConnection.getDate(); 
            Date accessDate = new Date(date); 
 
            System.out.println("Content-type: " + urlConnection.getContentType()); 
            System.out.println("Content-length: " + urlConnection.getContentLength()); 
            System.out.println("Last Modified: " + urlConnection.getLastModified()); 
            System.out.println("Access Date: " + accessDate); 
        } 
        catch (IOException e) { 
            System.out.println(e.getMessage()); 
        } 
	}
}
