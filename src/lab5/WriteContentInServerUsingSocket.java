//Name: Rohit Maharjam
//Roll no: 26
//Program to write content into server using socket
package lab5;
import java.io.*;
import java.net.*;

public class WriteContentInServerUsingSocket {
	public static void main(String[] args){
		try {
			Socket sc=new Socket("::1",8000);
			sc.setSoTimeout(15000);
			OutputStream out = sc.getOutputStream(); 
			Writer writer = new OutputStreamWriter(out, "UTF-8"); 
			writer = new BufferedWriter(writer); 
			writer.write("Hello from java program\r\n"); 
			writer.flush(); 

		}catch (IOException e) {
			System.out.print(e);
		}
}


}
