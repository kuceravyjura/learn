import java.net.*;
import java.io.*;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("connected to server...");

            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            DataOutputStream Sout = new DataOutputStream(out);
            ObjectInputStream inn = new ObjectInputStream(in);


            wordcounter obj = (wordcounter) inn.readObject();

            // Вызываем метод getResult и отправляем результат обратно на сервер
            String result = obj.getResult();
            Sout.writeUTF(result);
            System.out.println("Result: " + result);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

