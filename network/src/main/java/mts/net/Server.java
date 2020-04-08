package mts.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket socket = new ServerSocket(24410, 2000);
        System.out.println("Server started.. ");

        while (true) {

            Socket client = socket.accept();
            new SimpleServer(client).start();
        }
    }


}

class SimpleServer extends Thread {

    private Socket client;

    public SimpleServer(Socket client) {
        this.client = client;
    }

    public void run() {
        handleRequest();
    }

    private void handleRequest() {

        try {
            // Потом ввода
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            // поток вывода
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            // создаём билдер
            StringBuilder sb = new StringBuilder("Hello, ");
            //получаем строку текста из строки байт
            String userName = br.readLine();
            System.out.println("Server got a string: " + userName);
            Thread.sleep(2000);
            sb.append(userName);
            // пишем в райтер
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();

            br.close();
            bw.close();

            client.close();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }
}