import java.net.*;
import java.io.*;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("connected to server...");


            InputStream in = socket.getInputStream();

            ObjectInputStream inn = new ObjectInputStream(in);


            wordcounter obj = (wordcounter) inn.readObject();

            socket.close();
            System.out.println("connection closed...");

            // Вызываем метод getResult и отправляем результат обратно на сервер
            String result = obj.getResult();

            socket = new Socket("localhost", 5000);
            System.out.println("connected to server...");

            OutputStream out = socket.getOutputStream();
            DataOutputStream Sout = new DataOutputStream(out);

            Sout.writeUTF(result);
            System.out.println("Result: " + result);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

