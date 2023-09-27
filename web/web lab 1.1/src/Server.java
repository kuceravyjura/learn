import java.net.*;
import java.io.*;
import java.util.*;

public class Server {
    public static void main(String[] ar)    {
        int port = 6666; // ��������� ���� (����� ���� ����� ����� �� 1025 �� 65535)
        try {
            ServerSocket ss = new ServerSocket(port); // ������� ����� ������� � ����������� ��� � �������������� �����
            System.out.println("Waiting for a client...");

            Socket socket = ss.accept(); // ���������� ������ ����� ����������� � ������� ��������� ����� ���-�� �������� � ��������
            System.out.println("Got a client :) ... Finally, someone saw me through all the cover!");
            System.out.println();

            // ����� ������� � �������� ������ ������, ������ ����� �������� � �������� ������ �������.
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();
            ObjectOutputStream oout = new ObjectOutputStream(sout);;

            // ������������ ������ � ������ ���, ���� ����� ������������ ��������� ���������.
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);
            String line = null;

            String dataline ="apple,banana,apple,orange,orange,grape,orange,orange,orange";
            String[] lines ={"apple","banana","apple","banana","orange","grape"};
            List<String> list = new ArrayList<>(Arrays.asList("apple","banana","grape","banana","orange","grape"));
            while(true) {
                line = in.readUTF(); // ������� ���� ������ ������� ������ ������.
                if(Integer.parseInt(line)==1) {
                    System.out.println("The client received this line : " + dataline);

                    out.writeUTF(dataline); // �������� ������� ������� �� ����� ������ ������.
                }
                if(Integer.parseInt(line)==2) {
                    System.out.println("The client received this line : " + lines);

                    oout.writeObject(lines); // �������� ������� ������� �� ����� ������ ������.
                }
                if(Integer.parseInt(line)==3) {
                    System.out.println("The client received this line : " + list);

                    oout.writeObject(list); // �������� ������� ������� �� ����� ������ ������.
                }
                out.flush();
                line = in.readUTF(); // ������� ���� ������ ������� ������ ������.
                System.out.println(line);
                out.flush(); // ���������� ����� ��������� �������� ������.
                System.out.println("Waiting for the next line...");
                System.out.println();
            }
        } catch(Exception x) { x.printStackTrace(); }
    }
}
