package lab7;

import java.io.*;

public class MessageReceiver implements Runnable {
    private BufferedReader serverIn;

    public MessageReceiver(BufferedReader serverIn) {
        this.serverIn = serverIn;
    }

    public void run() {
        try {
            String message;
            while ((message = serverIn.readLine()) != null) {
                System.out.println("Received from server: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
