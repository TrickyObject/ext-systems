package mts.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket socket = new ServerSocket(24410, 2000);

        Map<String, Greetable> handlers = loadHandlers();

        System.out.println("Server started.. ");

        while (true) {

            Socket client = socket.accept();
            new SimpleServer(client, handlers).start();
        }
    }

    private static Map<String, Greetable> loadHandlers() {

        Map<String, Greetable> result = new HashMap<>();

        // расширение указывать не обязательно - написать буквально название
        try (InputStream is = Server.class.getClassLoader()
                .getResourceAsStream("ServerProperties")) {

            Properties properties = new Properties();
            properties.load(is);

            // заполняем мап result экземплярами классов, которые мы моем получить из проперти
            for (Object command : properties.keySet()) {
                String className = properties.getProperty(command.toString());
                //noinspection unchecked: className гарантиовано наследован от Greetable и указан в специальном файле пропертей
                Class<Greetable> cl = (Class<Greetable>) Class.forName(className);
                Greetable handler = cl.getConstructor().newInstance();
                result.put(command.toString(), handler);

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return result;
    }


}

class SimpleServer extends Thread {

    private Socket client;
    private Map<String, Greetable> handlers;

    public SimpleServer(Socket client, Map<String, Greetable> handlers) {
        this.client = client;
        this.handlers = handlers;
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

        Greetable handler = handlers.get(command);
        if (handler != null) {
            return handler.buildResponse(userName);
        }
        return "Hi, " + userName;
    }


}