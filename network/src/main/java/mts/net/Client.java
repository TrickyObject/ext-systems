package mts.net;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.logging.SocketHandler;

public class Client {

    public static void main(String[] args) throws IOException {

        for (int i = 0; i <= 5; i++) {

            SimpleClient simpleClient = new SimpleClient(i);
            simpleClient.start();
        }
    }
}


class SimpleClient extends Thread {

    private final static String[] COMMAND = {
            "HELLO", "MORNING", "DAY", "EVENING"
    };

    int cmdNumber;
    public SimpleClient(int cmdNumber){
        this.cmdNumber = cmdNumber;
    }

    public void run() {

        // указываем, куда ломимся
        try {
//            System.out.println("Started: " + LocalDateTime.now());
            Socket socket = new Socket("localhost", 24410);
            // Потом ввода
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // поток вывода
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String command = COMMAND[cmdNumber%COMMAND.length];
            // создаём билдер
            String sb = command + " " + "Mark";
            // пишем в райтер
            bw.write(sb);
            bw.newLine();
            bw.flush();


            String answer = br.readLine();
            System.out.println("Client received answer: " + answer);

            br.close();
            bw.close();
            socket.close();

//            System.out.println("Finished: " + LocalDateTime.now());

        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

    }

}