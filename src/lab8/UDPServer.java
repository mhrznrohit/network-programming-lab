//Name: Rohit Maharjam
//Roll no: 26
//Program to implement a UDP channel based time server client
package lab8;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;
public class UDPServer {
    public static void main(String[] args) {
        int serverPort = 8888;
        try {
            DatagramSocket serverSocket = new DatagramSocket(serverPort);
            System.out.println("UDP Time Server is running on port " + serverPort + "...");

            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                serverSocket.receive(receivePacket);

                String clientRequest = new String(receivePacket.getData()).trim();
                if (clientRequest.equals("TIME")) {
                    Date currentDate = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String currentTime = dateFormat.format(currentDate);

                    byte[] sendData = currentTime.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());

                    serverSocket.send(sendPacket);
                }
            }
        } catch (Exception e) {
            System.err.println("Error in the server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}



