package home.ur4eg.dev.dds;

import home.ur4eg.dev.dds.IOStreams.Message;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class WorkWithSerialize {
    static final int PORT = 50000;
    //public static FileOutputStream file;

    public static void createServer(){
        SocketListener socketListener = null;
        try {
            socketListener = new SocketListener(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread threadSocketListener = new Thread(socketListener);
        threadSocketListener.start();
    }

    public static void saveToFile(){
        Message msg = new Message("Y","qwas", new Date(System.currentTimeMillis()));
        FileOutputStream file;
        ObjectOutputStream oos = null;
        try {
            file = new FileOutputStream("d:\\SerializedMessageM.txt");
            oos = new ObjectOutputStream(file);
            //oos.writeObject(msg);
            msg.writeExternal(oos);
            System.out.println(msg);
            System.out.println("stream is closed");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveToFile2(){
        FileOutputStream file;
        ObjectOutputStream objectOutputStream;
        Message msg = new Message("N","aaa", new Date(System.currentTimeMillis()));
        try {
            file = new FileOutputStream("d:\\SerializedMessageA.txt");
            objectOutputStream = new ObjectOutputStream(file);
            objectOutputStream.writeObject(msg);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromFile(){
        FileInputStream file;
        ObjectInputStream ois;
        try {
            file = new FileInputStream("d:\\SerializedMessageM.txt");
            ois = new ObjectInputStream(file);
            long timeStart = System.currentTimeMillis();
            Message msg = new Message(ois);
            long timeEnd = System.currentTimeMillis();
            System.out.println((long)(timeEnd - timeStart));
            //msg.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromFile2(){
        FileInputStream file;
        ObjectInputStream objectInputStream;
        Message msg;
        try {
            file = new FileInputStream("d:\\SerializedMessageA.txt");
            objectInputStream = new ObjectInputStream(file);
            long timeStart = System.currentTimeMillis();
            msg = (Message)objectInputStream.readObject();
            long timeEnd = System.currentTimeMillis();
            System.out.println((long)(timeEnd - timeStart));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}

class SocketListener implements Runnable {
    private ServerSocket serverSocket;
    private static int port;
    private boolean isStopped;
    private Socket socket;

    public SocketListener(int port) throws IOException {
        this.port = port;
        isStopped = false;
        System.out.println("Server started on port " + port);
        serverSocket = new ServerSocket(port);

    }

    public void run() {
        while (!isStopped) {
            socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            new Thread(new ClientMonitor(socket)).start();
        }

    }
}

class ClientMonitor implements Runnable{
    static int countThreads = 0;
    private Socket clientSocket;
    public ClientMonitor(Socket socket){
        clientSocket = socket;
    }
    public void run(){
        countThreads++;
        BufferedWriter bufferedWriter;
        BufferedReader bufferedReader;
        System.out.println("ClientMonitor started. Port " + clientSocket.getRemoteSocketAddress().toString());
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            bufferedWriter.write("Connected to server " + clientSocket.getLocalSocketAddress().toString() + "\n");
            bufferedWriter.flush();
            String msg = null;
            while(!clientSocket.isClosed()){
                msg = bufferedReader.readLine();
                if(msg.equals("-1")) {
                    System.out.println(clientSocket.getRemoteSocketAddress().toString() + " -> Bye!");
                    bufferedReader.close();
                    bufferedWriter.close();
                    clientSocket.close();
                }
                else {
                    System.out.println(msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

