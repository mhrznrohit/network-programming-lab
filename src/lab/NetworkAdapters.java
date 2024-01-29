//Name: Rohit Maharjan
//Roll: 26
//Program to list the names and display name of all network adapters in the machine.

package lab;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetworkAdapters {

	public static void main(String[] args) {
		
		try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = interfaces.nextElement();
                System.out.println("Name: " + ni.getName());
                System.out.println("Display Name: " + ni.getDisplayName());
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
	
}
