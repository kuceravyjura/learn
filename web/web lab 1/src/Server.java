import java.net.*;
import java.io.*;
import java.util.*;

public class Server {
    public static void main(String[] args) {
        String test = "banana,banana,avokado";
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server is up...");

            while (true){
                Socket socket = server.accept();
                System.out.println("connected...");
                OutputStream out = socket.getOutputStream();
                InputStream in = socket.getInputStream();
                DataInputStream inn = new DataInputStream(in);

                // Создаем экземпляр класса
                wordcounter obj = new wordcounter(test);

                //System.out.println(obj.getResult());

                // Отправляем объект клиенту
                ObjectOutputStream Oout = new ObjectOutputStream(out);
                Oout.writeObject(obj);

                socket = server.accept();
                in = socket.getInputStream();
                inn = new DataInputStream(in);
                String answer = inn.readUTF();
                System.out.println(answer);
                //server.close();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}