//Name: Rohit Maharjan 
//Roll: 26
//Program check if a host is reachable or not.
package lab;

import java.net.InetAddress;

public class CheckHost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String host = "daraz.com";
        try {
            InetAddress inetAddress = InetAddress.getByName(host);
            boolean isReachable = inetAddress.isReachable(5000); 
            if (isReachable) {
                System.out.println(host + " is reachable");
            } else {
                System.out.println(host + " is not reachable");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
	}

}
