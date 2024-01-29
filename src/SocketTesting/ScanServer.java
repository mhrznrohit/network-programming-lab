package SocketTesting;
import java.net.*; 
import java.io.*;


public class ScanServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String host = args.length > 0 ? args[0] : "localhost"; 
		for (int i = 1; i < 512; i++)
		{ 
			try { 
				Socket s = new Socket(host, i); 
				System.out.println("There is a server on port " + i + " of " + host); 
				s.close(); 
			} catch (UnknownHostException ex) 
			{ System.err.println(ex); 
				break;
			 } catch (IOException ex) 
			{ // must not be a server on this port 
				 // System.out.print("IOException Occured");
			}

	}
	
	
	}
}

