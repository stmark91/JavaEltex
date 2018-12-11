package webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args)  {
        while(true) {
            try (ServerSocket serverSocket = new ServerSocket(80)) {
                Socket client = serverSocket.accept();
                Runnable runnable = new MyTread(client);
                Thread thread = new Thread(runnable);
                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
