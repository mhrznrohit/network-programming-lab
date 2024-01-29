//Name: Rohit Maharjam
//Roll no: 26
package sslchat;
import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SecureChatServer {
	private static final int PORT = 3373;
    private static final String KEYSTORE_FILE = "C:\\local.keystore";
    private static final String KEYSTORE_PASSWORD = "admin1234";

    public static void main(String[] args) {
        try {
            // Load the keystore containing the server's private key and certificate
            char[] keystorePassword = KEYSTORE_PASSWORD.toCharArray();
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(KEYSTORE_FILE), keystorePassword);

            // Create and configure SSL context
            SSLContext sslContext = SSLContext.getInstance("TLS");
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            keyManagerFactory.init(keyStore, keystorePassword);
            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

            // Create SSL server socket factory
            SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();

            // Create server socket
            SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

            System.out.println("Secure Chat Server is running on port " + PORT);

            // Accept and handle client connections in a loop
            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

                // Create a new thread to handle the client's messages
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}