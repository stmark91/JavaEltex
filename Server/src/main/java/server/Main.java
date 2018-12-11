package server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        InetAddress[] address = InetAddress.getAllByName("yandex.ru");
        for (InetAddress i :address) {
            String addrArray = i.getHostAddress();
            System.out.println(addrArray);
        }
        while(true) {
            try (ServerSocket serverSocket = new ServerSocket(1117)) {
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
