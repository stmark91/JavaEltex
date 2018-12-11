package webserver;

import java.io.*;
import java.net.Socket;

public class MyTread implements Runnable {
    private Socket socket;
    @Override
    public void run() {
        String file;
        try {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream((socket.getInputStream()));
            String entry = in.readLine();
            String subStr[] = entry.split(" ");
            if(subStr[1].equals("/")){
                file = "index.html";
            }else{
                System.out.println(subStr[1]);
                file = subStr[1].substring(1);
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int i = 0;
            String line[] = new String[256];
            while ((line[i] = reader.readLine()) != null) {
                i++;
            }
            reader.close();
            int d = line.length;
            StringBuilder answer = new StringBuilder("HTTP/1.1 200 OK" + "\r\n" +
                    "Content-Length: " + d * 8 + "\r\n" + "\r\n");
            for (int j = 0; j < i; j++){
                answer.append(line[j]).append("\r\n");
            }
            Thread.sleep(2000);
            System.out.println(answer);
            out.writeUTF(String.valueOf(answer));
            out.flush();
            /*in.close();
            out.close();
            socket.close();*/
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
