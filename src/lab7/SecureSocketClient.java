//Name: Rohit Maharjam
//Roll no: 26
//Program to implement a secure socket client application to download content from tu.edu.np.
package lab7;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
public class SecureSocketClient {
    public static void main(String[] args) {
        String url = "https://tu.edu.np"; // URL to download content from

        try {
            // Create a URL object with the specified URL
            URL downloadUrl = new URL(url);
            HttpsURLConnection connection = (HttpsURLConnection) downloadUrl.openConnection();
            connection.setSSLSocketFactory(getSSLContext().getSocketFactory());
            connection.setHostnameVerifier((hostname, session) -> true);

            connection.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static javax.net.ssl.SSLContext getSSLContext() {
        javax.net.ssl.SSLContext sslContext = null;
        try {

            javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[]{
                    new javax.net.ssl.X509TrustManager() {
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                        }

                        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                        }
                    }
            };

            sslContext = javax.net.ssl.SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sslContext;
    }
}


