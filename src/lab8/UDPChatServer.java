//Name: Rohit Maharjam
//Roll no: 26
//Program to implement a UDP chat server client.
package lab8;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;
public class UDPChatServer {
    private static final int SERVER_PORT = 9876;
    private static List<DatagramPacket> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(SERVER_PORT);
            System.out.println("UDP Chat Server is running...");

            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String message = new String(receivePacket.getData()).trim();
                System.out.println("Received from client: " + message);

                if (!message.isEmpty()) {
                    for (DatagramPacket client : clients) {
                        if (client.getPort() != receivePacket.getPort()) {
                     serverSocket.send(new DatagramPacket(receivePacket.getData(), receivePacket.getLength(), client.getAddress(), client.getPort()));
                        }
                    }
                    clients.add(receivePacket);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



