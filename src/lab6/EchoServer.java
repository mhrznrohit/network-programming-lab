//Name: Rohit Maharjam
//Roll no: 26
//Program for echo-client and echo-server application using socket channels
package lab6;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
public class EchoServer {
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
				// Read the content from the client
				ByteBuffer buffer = ByteBuffer.allocate(1024);
				clientChannel.read(buffer);
				buffer.flip();
				String content = new String(buffer.array(), 0, buffer.limit());
				System.out.println("Received from client: " + content);
				// Write back the same content to the client
				clientChannel.write(buffer);
				// Close the client channel
				clientChannel.close();
				System.out.println("Client disconnected.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}