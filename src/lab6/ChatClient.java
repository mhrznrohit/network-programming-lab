//Name: Rohit Maharjam
//Roll no: 26
//Program for chat-client and chat-server application using socket channels.
package lab6;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
public class ChatClient {
	private static final String SERVER_HOST = "localhost";
	private static final int SERVER_PORT = 9999;
	private static final String END_MESSAGE = "exit";

	public static void main(String[] args) {
		try {
			// Open a socket channel
			SocketChannel socketChannel = SocketChannel.open();
			// Connect to the server
			socketChannel.connect(new InetSocketAddress(SERVER_HOST, SERVER_PORT));
			System.out.println("Connected to the server.");
			// Start a new thread to handle incoming messages from the server
			new Thread(() -> receiveMessages(socketChannel)).start();
			// Read input from the console and send messages to the server
			Scanner scanner = new Scanner(System.in);
			String message;
			do {
				System.out.print("Enter your message (or 'exit' to quit): ");
				message = scanner.nextLine();
				// Send the message to the server
				ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
				socketChannel.write(buffer);
			} while (!message.equalsIgnoreCase(END_MESSAGE));
			// Close the socket channel
			socketChannel.close();
			scanner.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void receiveMessages(SocketChannel socketChannel) {
		try {
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			while (true) {
				// Read the message from the server
				buffer.clear();
				int bytesRead = socketChannel.read(buffer);
				if (bytesRead <= 0) {
					// Server has closed the connection
					break;
				}
				buffer.flip();
				String message = new String(buffer.array(), 0, buffer.limit());
				System.out.println("Received from server: " + message);
			}
			// Close the socket channel
			socketChannel.close();
			System.out.println("Disconnected from the server.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
