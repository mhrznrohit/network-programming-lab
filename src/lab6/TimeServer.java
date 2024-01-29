//Name: Rohit Maharjam
//Roll no: 26
//Program for time-client and time-server application using socket channels
package lab6;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
public class TimeServer {
	private static final int PORT = 9999;

	public static void main(String[] args) {
		try {
			// Open a server socket channel
			ServerSocketChannel serverChannel = ServerSocketChannel.open();
			// Bind the server socket channel to a specific port
			serverChannel.bind(new InetSocketAddress(PORT));
			System.out.println("Server started. Waiting for client connections...");
			while (true) {
				// Accept client connections
				SocketChannel clientChannel = serverChannel.accept();
				System.out.println("Client connected: " + clientChannel.getRemoteAddress());
				// Get the current system time
				LocalDateTime currentTime = LocalDateTime.now();
				String timeString = currentTime.toString();
				// Write the time to the client
				ByteBuffer buffer = ByteBuffer.allocate(1024);
				buffer.put(timeString.getBytes());
				buffer.flip();
				clientChannel.write(buffer);
				buffer.clear();
				// Close the client channel
				clientChannel.close();
				System.out.println("Client disconnected.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
