//Name: Rohit Maharjam
//Roll no: 26
//Program to read content from server using socket.
package lab5;
import java.io.*;
import java.net.*;

public class ReadContentFromServerUsingSocket {
	public static void main(String[] args) {
		   try {
	            // Create a socket to connect to the server
	            Socket socket = new Socket("localhost", 8000);

	            // Create input and output streams for the socket
	            InputStream in = socket.getInputStream();
	            OutputStream out = socket.getOutputStream();

	            // Send a request to the server
	            String request = "GET / HTTP/1.1\r\nHost: localhost\r\n\r\n";
	            out.write(request.getBytes());

	            // Read the response from the server
	            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	            String line;
	            while ((line = reader.readLine()) != null) {
	                System.out.println(line);
	            }

	            // Close the streams and the socket
	            reader.close();
	            in.close();
	            out.close();
	            socket.close();
	        } 
		   catch (IOException e) {
	            e.printStackTrace();
	        }
 }
}
