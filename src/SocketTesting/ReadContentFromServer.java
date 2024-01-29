package SocketTesting;

import java.net.*;
import java.io.*;
public class ReadContentFromServer {
	public static void main(String[] args) throws IOException{
//		Socket socket = new Socket("localhost", 80); 
//		socket.setSoTimeout(1000); 
//		InputStream in = socket.getInputStream(); 
//		//StringBuilder time = new StringBuilder(); 
//		InputStreamReader reader = new InputStreamReader(in, "ASCII"); 
//	for (int c = reader.read(); c != -1; c = reader.read()) 
//	{ 
//			time.append((char) c); 
//		} 
//			System.out.println(time); 
//		
//		
//		
//			socket.close(); 
		
//	}
		try {
            // Create a socket to connect to the server
            Socket socket = new Socket("localhost", 80);

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
        } catch (IOException e) {
            e.printStackTrace();
        }

}
}