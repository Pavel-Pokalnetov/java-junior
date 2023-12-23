package loc.server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientManager implements Runnable {
    private final Socket socket;
    public final static ArrayList<ClientManager> clients = new ArrayList<>();

    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public ClientManager(Socket socket) {
        try{
            this.socket = socket;
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            name = bufferedReader.readLine();
            clients.add(this);
            System.out.println();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String messageFromClient;
        while(socket.isConnected(){

        }
    }
}
