package lab7;

import javax.net.ssl.SSLSocket;
import java.io.*;

public class ClientHandler implements Runnable {
    private SSLSocket sslSocket;

    public ClientHandler(SSLSocket sslSocket) {
        this.sslSocket = sslSocket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received from client: " + message);
            }

            sslSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
