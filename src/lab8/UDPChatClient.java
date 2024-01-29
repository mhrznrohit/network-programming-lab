//Name: Rohit Maharjam
//Roll no: 26
//Program to implement a UDP chat server client.
package lab8;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPChatClient {
    private static final int SERVER_PORT = 9876;
    private static final String SERVER_HOST = "localhost";

    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName(SERVER_HOST);

            Thread receiverThread = new Thread(() -> {
                try {
                    while (true) {
                        byte[] receiveData = new byte[1024];
                        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                        System.out.println("Enter Message:");
                        clientSocket.receive(receivePacket);

                        String message = new String(receivePacket.getData()).trim();
                        System.out.println("Received from server: " + message);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            receiverThread.start();

            Scanner scanner = new Scanner(System.in);
            while (true) {
                String message = scanner.nextLine();
                byte[] sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, SERVER_PORT);
                clientSocket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

