//Name: Rohit Maharjan
//Roll: 26
//Program to find all address of "dns.google.com"

package lab;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetallAddress {

	public static void main(String[] args) {
		String url="dns.google.com";
		try {
			InetAddress[] ip1=InetAddress.getAllByName(url);
			System.out.print("\nAddresses of dns.google.com\n");
			for(InetAddress ad:ip1) {
				System.out.println(ad.getHostAddress());
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
