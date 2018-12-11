package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MyTread implements Runnable {
    private Socket socket;
    @Override
    public void run() {
        try {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Output stream created");
            DataInputStream in = new DataInputStream((socket.getInputStream()));
            System.out.println("Input stream created");
            while (!socket.isClosed()) {
                System.out.println("Server reading from channel");
                String entry = in.readUTF();
                System.out.println("READ from client message - " + entry);
                System.out.println("Server try writing to channel");
                if (entry.equalsIgnoreCase("quit")) {
                    System.out.println("Client initialize connections suicide ...");
                    out.writeUTF("Server reply - " + entry + " - OK");
                    out.flush();
                    Thread.sleep(3000);
                    break;
                }
                Thread.sleep(2000);
                out.writeUTF("Server reply - " + entry + " - OK");
                System.out.println("Server wrote message to client.");
                out.flush();
                Thread.sleep(2000);
            }
            System.out.println("Client disconnected");
            System.out.println("Closing connections & channels.");
            in.close();
            out.close();
            socket.close();
            System.out.println("Closing connections & channels - DONE.");
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }

    MyTread(Socket s) {
        setSocket(s);
    }

    private void setSocket(Socket socket) {
        this.socket = socket;
    }
}
