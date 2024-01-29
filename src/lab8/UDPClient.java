//Name: Rohit Maharjam
//Roll no: 26
//Program to implement a UDP channel based time server client
package lab8;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class UDPClient {
    public static void main(String[] args) {
        String serverHostname = "localhost"; // Change to the server's hostname or IP address
        int serverPort = 8888;

        try {
            DatagramSocket clientSocket = new DatagramSocket();

            String request = "TIME";
            byte[] sendData = request.getBytes();
            InetAddress serverAddress = InetAddress.getByName(serverHostname);
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);

            clientSocket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            clientSocket.receive(receivePacket);

            String currentTime = new String(receivePacket.getData()).trim();
            System.out.println("Server's Current Time: " + currentTime);

            clientSocket.close();
        } catch (Exception e) {
            System.err.println("Error in the client: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
