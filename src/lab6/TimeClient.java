//Name: Rohit Maharjam
//Roll no: 26
//Program for time-client and time-server application using socket channels
package lab6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class TimeClient {
	private static final String SERVER_HOST = "localhost";
	private static final int SERVER_PORT = 9999;

	public static void main(String[] args) {
		try {
			// Open a socket channel
			SocketChannel socketChannel = SocketChannel.open();
			// Connect to the server
			socketChannel.connect(new InetSocketAddress(SERVER_HOST, SERVER_PORT));
			// Read the time from the server
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			socketChannel.read(buffer);
			buffer.flip();
			String timeString = new String(buffer.array(), 0, buffer.limit());
			System.out.println("Server time: " + timeString);
			// Close the socket channel
			socketChannel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}