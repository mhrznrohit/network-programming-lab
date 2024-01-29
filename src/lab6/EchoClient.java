//Name: Rohit Maharjam
//Roll no: 26
//Program for echo-client and echo-server application using socket channels
package lab6;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
public class EchoClient {
	private static final String SERVER_HOST = "localhost";
	private static final int SERVER_PORT = 9999;
	public static void main(String[] args) {
		try {
			// Open a socket channel
			SocketChannel socketChannel = SocketChannel.open();
			// Connect to the server
			socketChannel.connect(new InetSocketAddress(SERVER_HOST, SERVER_PORT));
			// Read input from the console
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter content to send to the server: ");
			String content = scanner.nextLine();
			// Write the content to the server
			ByteBuffer buffer = ByteBuffer.wrap(content.getBytes());
			socketChannel.write(buffer);
			// Read the echoed content from the server
			buffer.clear();
			socketChannel.read(buffer);
			buffer.flip();
			String echoedContent = new String(buffer.array(), 0, buffer.limit());
			System.out.println("Echoed content from server: " + echoedContent);
			// Close the socket channel
			socketChannel.close();
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
