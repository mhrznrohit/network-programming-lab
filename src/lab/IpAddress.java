//Name: Rohit Maharjan
//Roll: 26
//Program to find the IPV4 and IPV6 of a given host.
package lab;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpAddress {

	public static void main(String[] args) {
		String hostname = "dns.google.com";
        try {
            InetAddress[] addresses = InetAddress.getAllByName(hostname);
            for (InetAddress addr : addresses) {
                if (addr instanceof java.net.Inet4Address) {
                    System.out.println("IPv4 Address: " + addr.getHostAddress());
                } else if (addr instanceof java.net.Inet6Address) {
                    System.out.println("IPv6 Address: " + addr.getHostAddress());
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
	}


