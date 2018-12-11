package client;

import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        try (Socket client = new Socket("localhost", 1117);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            DataInputStream inputStream = new DataInputStream(client.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());){
            System.out.println("Client connected to socket.");
            System.out.println("Client writing channel = oos & reading channel = ois initialized.");
            while (!client.isOutputShutdown()){
                if(br.ready()){
                    System.out.println("Client start writing in channel...");
                    Thread.sleep(1000);
                    String clientCommand = br.readLine();
                    outputStream.writeUTF(clientCommand);
                    outputStream.flush();
                    System.out.println("Client sent message " + clientCommand + " to server.");
                    Thread.sleep(1000);
                    if(clientCommand.equalsIgnoreCase("quit")) {
                        System.out.println("Client kill connections");
                        Thread.sleep(2000);
                        if (inputStream.read() > -1) {
                            System.out.println("reading1...");
                            String in = inputStream.readUTF();
                            System.out.println(in);
                        }
                        break;
                    }
                    System.out.println("Client sent message & start waiting for data from server...");
                    Thread.sleep(2000);
                    System.out.println("reading2...");
                    String in = inputStream.readUTF();
                    System.out.println(in);
                }
            }
            System.out.println("Closing connections & channels on clientSide - DONE.");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
