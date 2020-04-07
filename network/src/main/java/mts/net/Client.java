package mts.net;

import java.io.*;
import java.net.Socket;
import java.util.logging.SocketHandler;

public class Client {

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 10; i++) {
            sendRequest();
        }
    }

    private static void sendRequest() throws IOException {

        // указываем, куда ломимся
        Socket socket = new Socket("localhost", 24410);

        // Потом ввода
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // поток вывода
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        // создаём билдер
        String sb = new String("Mark");
        // пишем в райтер
        bw.write(sb);
        bw.newLine();
        bw.flush();

        System.out.println("Client received answer");
        String answer = br.readLine();
        System.out.println(answer);

        br.close();
        bw.close();
        socket.close();

    }
}
