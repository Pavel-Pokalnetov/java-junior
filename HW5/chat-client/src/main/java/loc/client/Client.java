package loc.client;

import java.io.*;
import java.net.Socket;

public class Client {
    private final Socket socket;
    private final String name;
    private BufferedReader bufferedReader = null;
    private BufferedWriter bufferedWriter = null;

    public Client(Socket socket, String userName) {
        this.socket = socket;
        this.name = userName;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            try {
                closeEverything(socket, bufferedWriter, bufferedReader);
            } catch (IOException i) {
                i.printStackTrace();
                new RuntimeException(i);
            }
        }
    }

    private void closeEverything(Socket socket, BufferedWriter bufferedWriter, BufferedReader bufferedReader) throws IOException {
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
        if (socket != null) {
            socket.close();
        }
    }

    /**
     * Слушатель входящих сообщений от сервера
     */
    public void listenForMessage() {

    }

    /**
     * Отправка сообщений на сервер
     */
    public void sendMessage() {

    }
}
