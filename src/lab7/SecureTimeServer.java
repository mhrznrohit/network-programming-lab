//Name: Rohit Maharjam
//Roll no: 26
//Program to implement a secure client server time server application.
package lab7;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.util.Date;

public class SecureTimeServer {
    public static void main(String[] args) {
        String keystorePath = "C:\\local.keystore";
        char[] keystorePassword = "admin1234".toCharArray();

        try {
            // Load the keystore containing the server's key and certificate
            KeyStore keystore = KeyStore.getInstance("JKS");
            keystore.load(new FileInputStream(keystorePath), keystorePassword);

            // Create the SSL context with the server's key and certificate
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(keystore, keystorePassword);
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(keystore);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

            // Create the SSL server socket
            SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8000);

            System.out.println("Secure Time Server is running...");

            while (true) {
                // Wait for a client to connect
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

                // Get the output stream to write the time to the client
                OutputStream outputStream = sslSocket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream));

                // Get the current time and send it to the client
                Date currentTime = new Date();
                printWriter.println(currentTime.toString());
                printWriter.flush();

                // Close the socket
                sslSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
