//Name: Rohit Maharjam
//Roll no: 26
//Program for chat-client and chat-server application using socket channels.
package lab6;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
public class ChatServer {
	private static final int PORT = 9999;
	private static final String END_MESSAGE = "exit";
	private static List<SocketChannel> clients = new ArrayList<>();

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
				clients.add(clientChannel);
				System.out.println("Client connected: " + clientChannel.getRemoteAddress());
				// Start a new thread to handle client messages
				new Thread(() -> handleClientMessages(clientChannel)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void handleClientMessages(SocketChannel clientChannel) {
		try {
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			String clientAddress = clientChannel.getRemoteAddress().toString();
			while (true) {
				// Read the message from the client
				buffer.clear();
				int bytesRead = clientChannel.read(buffer);
				if (bytesRead <= 0) {
					// Client has disconnected
					break;
				}
				buffer.flip();
				String message = new String(buffer.array(), 0, buffer.limit());
				System.out.println("Received from " + clientAddress + ": " + message);
				// Broadcast the message to all connected clients
				broadcastMessage(message, clientChannel);
				if (message.equalsIgnoreCase(END_MESSAGE)) {
					// Client wants to exit
					break;
				}
			}
			// Remove the client from the clients list
			clients.remove(clientChannel);
			System.out.println("Client disconnected: " + clientAddress);
			// Close the client channel
			clientChannel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void broadcastMessage(String message, SocketChannel senderChannel) throws IOException {
		for (SocketChannel clientChannel : clients) {
			if (clientChannel != senderChannel) {
				ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
				clientChannel.write(buffer);
			}
		}
	}
}
