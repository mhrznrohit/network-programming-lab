package SocketTesting;
import java.net.*;
import java.io.*;

public class WriteContentInServer {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		try {
			@SuppressWarnings("resource")
			Socket socket = new Socket("time.nist.gov", 13); 
			socket.setSoTimeout(15000); 
			OutputStream out = socket.getOutputStream(); 
			Writer writer = new OutputStreamWriter(out, "UTF-8"); 
			writer = new BufferedWriter(writer); 
			writer.write("bye\r\n"); 
			writer.flush(); 

		}
		catch(IOException e) {
			System.out.print("IOException Occured");
			
		}
		
		
	}

}
