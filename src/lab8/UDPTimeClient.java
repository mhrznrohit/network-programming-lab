//Name: Rohit Maharjam
//Roll no: 26
//Program to implement a UDP time server client
package lab8;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPTimeClient {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9876;

            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            clientSocket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            String time = new String(receivePacket.getData());
            System.out.println("Server Time: " + time);

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
