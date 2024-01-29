//Name: Rohit Maharjam
//Roll no: 26
//Program to implement a secure client server time server application.
package lab7;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;

public class SecureTimeClient {
    public static void main(String[] args) {
        String truststorePath = "C:\\local.keystore";
        char[] truststorePassword = "admin1234".toCharArray();

        try {
            // Load the truststore containing the server's certificate
            KeyStore truststore = KeyStore.getInstance("JKS");
            truststore.load(new FileInputStream(truststorePath), truststorePassword);

            // Create the SSL context with the truststore containing the server's certificate
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(truststore);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), null);

            // Create the SSL socket
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("localhost", 8000);
            // Get the input stream to read the time from the server
            InputStream inputStream = sslSocket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            // Read the time from the server and print it
            String time = bufferedReader.readLine();
            System.out.println("Server time: " + time);
            // Close the socket
            sslSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
