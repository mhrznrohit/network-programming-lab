//Name: Rohit Maharjan
//Roll: 26
//Program to find the canocial name of "google.com"
package lab;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Canonicalname {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="google.com";
		
		try{
			InetAddress ip1= InetAddress.getByName(url);
			String hostname=ip1.getHostName();
			String canocialname=ip1.getCanonicalHostName();
			System.out.println("Host name: "+hostname+"\nCanonical Name: "+canocialname);
			
		}
		catch(UnknownHostException e)
		{
			System.out.println("error: "+e);
		}
	}

}
