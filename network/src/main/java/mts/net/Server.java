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

            //получаем строку текста из строки байт
            String request = br.readLine();
            String[] lines = request.split("\\s+");
            String command = lines[0];
            String userName = lines[1];
            System.out.println("Server got a string 1 : " + command);
            System.out.println("Server got a string 2 : " + userName);

            String response = buildResponse(command, userName);
            bw.write(response);
            bw.newLine();
            bw.flush();

            br.close();
            bw.close();

            client.close();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }

    private  String buildResponse(String command, String userName) {

        switch (command) {
            case "HELLO" : return  "Hello, " + userName;
            case "MORNING" : return  "Morning, " + userName;
            case "DAY" : return  "Day, " + userName;
            case "EVENING" : return  "Evening, " + userName;
            default: return "HI, BEACH!";
        }
    }
}