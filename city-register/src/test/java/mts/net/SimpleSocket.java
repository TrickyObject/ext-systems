package mts.net;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleSocket {

    // Повторить 88 для понимания
    @Test
    public void simpleSocket() throws IOException {

        // посмотреть технологии джава
        //ресурс, куда обращаемся
        Socket socket = new Socket("localhost", 8080);

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
//        гет-запрос
        String command = "GET /test HTTP/1.1\r\nHost:Test\r\n\r\n";
//        получили поток байт
        outputStream.write(command.getBytes());
//        неотложная отправка
        outputStream.flush();

        // чтение потока
        int c = 0;
        while ((c = inputStream.read()) != -1) {
            System.out.print((char) c);
        }

        // закрываем ресурс
        socket.close();
    }
}
