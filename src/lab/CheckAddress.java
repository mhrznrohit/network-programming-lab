//Name: Rohit Maharjan
//Roll: 26
//Program to check address of "fohss.tu.edu.np"
package lab;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class CheckAddress {
		public static void main(String[] args) {
			try {
				InetAddress addr = InetAddress.getByName("fohss.tu.edu.np");
				System.out.print(addr);
			}
			catch(UnknownHostException e) {
				System.out.println(e.getMessage());
			}
		}

	
}
