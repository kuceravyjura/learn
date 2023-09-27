import java.net.*;
import java.io.*;
import java.util.*;

public class Server {
    public static void main(String[] ar)    {
        int port = 6666; // случайный порт (может быть любое число от 1025 до 65535)
        try {
            ServerSocket ss = new ServerSocket(port); // создаем сокет сервера и привязываем его к вышеуказанному порту
            System.out.println("Waiting for a client...");

            Socket socket = ss.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
            System.out.println("Got a client :) ... Finally, someone saw me through all the cover!");
            System.out.println();

            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиенту.
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();
            ObjectOutputStream oout = new ObjectOutputStream(sout);;

            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);
            String line = null;

            String dataline ="apple,banana,apple,orange,orange,grape,orange,orange,orange";
            String[] lines ={"apple","banana","apple","banana","orange","grape"};
            List<String> list = new ArrayList<>(Arrays.asList("apple","banana","grape","banana","orange","grape"));
            while(true) {
                line = in.readUTF(); // ожидаем пока клиент пришлет строку текста.
                if(Integer.parseInt(line)==1) {
                    System.out.println("The client received this line : " + dataline);

                    out.writeUTF(dataline); // отсылаем клиенту обратно ту самую строку текста.
                }
                if(Integer.parseInt(line)==2) {
                    System.out.println("The client received this line : " + lines);

                    oout.writeObject(lines); // отсылаем клиенту обратно ту самую строку текста.
                }
                if(Integer.parseInt(line)==3) {
                    System.out.println("The client received this line : " + list);

                    oout.writeObject(list); // отсылаем клиенту обратно ту самую строку текста.
                }
                out.flush();
                line = in.readUTF(); // ожидаем пока клиент пришлет строку текста.
                System.out.println(line);
                out.flush(); // заставляем поток закончить передачу данных.
                System.out.println("Waiting for the next line...");
                System.out.println();
            }
        } catch(Exception x) { x.printStackTrace(); }
    }
}
