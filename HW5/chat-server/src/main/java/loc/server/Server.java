package loc.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final int PORT = 1425;
    private final ServerSocket serverSocket;
    public Server() throws IOException {
        serverSocket = new ServerSocket(PORT);
    }
    public void start(){

        try{
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                ClientManager clientManager = new ClientManager(socket)
                System.out.println("Подключение клиента");
                Thread clientThread = new Thread(clientManager);
                clientThread.start();
            }
        }catch (IOException e){

        }
    }
}