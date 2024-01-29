//Name: Rohit Maharjan
//Roll: 26
//Program to find name and Ip address of local Machine

package lab;

import java.net.InetAddress;

public class LocalhostName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress ip1=InetAddress.getLocalHost();
			String hn=ip1.getHostName();
			System.out.println("host name is "+hn);
			System.out.println("host address is "+ip1.getHostAddress());
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
