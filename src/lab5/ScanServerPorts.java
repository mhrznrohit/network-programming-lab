//Name: Rohit Maharjam
//Roll no: 26
//Program to scan a server for lower 512 available ports
package lab5;
import java.io.IOException;
import java.net.Socket;

public class ScanServerPorts {
	public static void main(String[] args) {		
	      String serverAddress = "::1"; 
     	      int startPort = 1;
      	      int endPort = 512;

      		for (int port = startPort; port <= endPort; port++) {
          			try (Socket socket = new Socket(serverAddress, port)) {
              		System.out.println("Port " + port + " is open.");
          			} catch (IOException e) {
              			// port is closed or unreachable       	
          			}
      		}
}
}
