//Name: Rohit Maharjan 
//Roll: 26
//Program to check whether the address is Ipv4 or Ipv6.
package lab;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ipv4_Ipv6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="facebook.com";
		try {
			InetAddress ip1= InetAddress.getByName(url);
			byte[] addr=ip1.getAddress();
			int len=addr.length;
			if(len==4) {
				System.out.println("Ipv4 address");
			}else if(len==16) {
				System.out.println("Ipv6 address");
			}
		}catch(UnknownHostException e) {
			System.out.println("error"+e);
		}
	}
}


