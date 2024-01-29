//Name: Rohit Maharjam
//Roll no: 26
//Program to to demonstrate SPAM checking.
package lab;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SpamChecking {
	public static final String URLEX="sbl.spamhaus.org";

	public static void main(String[] args) {
		String host = "177.239.143.211";
		if(isSpammer(host)) {
				System.out.println(host+" is known spammer");
			}else {
				System.out.println(host+" is legitimate");
			}		
	}
	public static boolean isSpammer(String arg) {
		try {
			InetAddress addr=InetAddress.getByName(arg);
			byte[] quad=addr.getAddress();
			String query=URLEX;
			for(byte octet:quad) {
				int unsignedByte =octet<0?octet+256:octet;
				query=unsignedByte+"."+query;
			}
			InetAddress.getByName(query);
			return true;
		}catch(UnknownHostException e) {
			return false;
		}
	}

}
