package home.ur4eg.dev.dds;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;

class SocketServer{
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(50000);
        Socket socket = serverSocket.accept();
        System.out.println("Connection istablished with " + socket.getRemoteSocketAddress());
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer.write("Connected to " + socket.getLocalSocketAddress().toString());
        String msg;
        do{
            msg = reader.readLine();
            System.out.println(socket.getRemoteSocketAddress().toString() + " -> " + msg);
            writer.write(socket.getLocalSocketAddress().toString() + " -> " + msg + "\n");
            //writer.newLine();
            writer.flush();
        } while (!msg.equals("exit"));
        writer.close();
        reader.close();
        socket.close();
    }
}

class SocketServer2{
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket1 = new ServerSocket(50000);
        ServerSocket serverSocket2 = new ServerSocket(40000);
        Socket socket1 = serverSocket1.accept();
        Socket socket2 = serverSocket2.accept();
        BufferedWriter writer1 = new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
        BufferedWriter writer2 = new BufferedWriter(new OutputStreamWriter(socket2.getOutputStream()));
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
        String msg = "";

        do{
            if(reader1.ready()){
                msg = reader1.readLine();
                writer2.write(msg);
                writer2.newLine();
                writer2.flush();
            }
            if(reader2.ready()){
                msg = reader2.readLine();
                writer1.write(msg);
                writer1.newLine();
                writer1.flush();
            }
        } while (!msg.equals("exit"));
        writer1.close();
        reader1.close();
        socket1.close();
        writer2.close();
        reader2.close();
        socket2.close();
    }
}

public class SocketServerListener {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(50000);
        Socket socket = serverSocket.accept();
        String msg = "";

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        do {
            if(reader.ready()){
                msg = reader.readLine();
                writer.write(msg);
                writer.newLine();
                writer.flush();
                System.out.println(msg);
            }
        } while (!msg.equals("exit"));
        writer.close();
        reader.close();
    }
}

class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 50000);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String msg = "";
        Scanner in = new Scanner(System.in);
        while (!socket.isClosed() || msg.equals("exit")) {
            msg = in.nextLine();
            writer.write(msg);
            writer.newLine();
            writer.flush();
            System.out.println(bufferedReader.readLine());
        }
        writer.close();
        bufferedReader.close();

    }
}
