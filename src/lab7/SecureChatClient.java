package lab7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;


public class SecureChatClient {
    private static final String SERVER_HOSTNAME = "localhost";
    private static final int SERVER_PORT = 8888;

    public static void main(String[] args) {
    	System.setProperty("https.protocols", "TLSv1.2");

        try {
        

            SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket) sslSocketFactory.createSocket(SERVER_HOSTNAME, SERVER_PORT);

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            new Thread(() -> {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String message;
                    while ((message = reader.readLine()) != null) {
                        System.out.println("Server: " + message);
                    }
                } catch (IOException e) {
                    System.err.println("Error reading from server: " + e.getMessage());
                    e.printStackTrace();
                }
            }).start();

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            while ((userInput = consoleReader.readLine()) != null) {
                writer.println(userInput);
            }

            socket.close();
        } catch (IOException e) {
            System.err.println("Error in the client: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

