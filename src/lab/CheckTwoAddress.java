//Name: Rohit Maharjan
//Roll: 26
// Program to check whether the addresses tu.edu.np and fohss.tu.edu.np are same.

package lab;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class CheckTwoAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url1="tu.edu.np";
		String url2="fohss.tu.edu.np";
		try {
			InetAddress ip1=InetAddress.getByName(url1);
			InetAddress ip2=InetAddress.getByName(url2);
			
			if(ip1.equals(ip2)) {
				System.out.println("Both addresses are same");
			}
			else {
				System.out.println("Addresses are not same");
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
