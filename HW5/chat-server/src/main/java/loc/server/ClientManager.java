package loc.server;


import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ClientManager implements Runnable {
    public static final String SEPARATOR = "&&";
    private final Socket socket;
    public static HashMap<String, ClientManager> clients = new HashMap<>();

    private String name;

    private String socketClient;

    private BufferedReader bufferedReader;

    private BufferedWriter bufferedWriter;

    public ClientManager(Socket socket) {
        this.socket = socket;
        try {
            socketClient = socket.getInetAddress().toString().split("/")[1] + ":" + socket.getPort();
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            name = bufferedReader.readLine();
            if (name.equalsIgnoreCase("all")) throw new IOException();
            clients.put(socketClient, this);
            broadcastMessage("*** Подключился @"+name);
        } catch (IOException e) {
            e.printStackTrace();
            closeEverithing(socket, bufferedWriter, bufferedReader);
        }
    }

    @Override
    public void run() {
        String messageFromClient;
        while (socket.isConnected()) {
            try {
                messageFromClient = bufferedReader.readLine();

                messageProcessing(messageFromClient);

                System.out.printf("Клиент %s: %s\n", name, messageFromClient);

            } catch (IOException e) {
                closeEverithing(socket, bufferedWriter, bufferedReader);
                break;
            }
        }

    }

    private void messageProcessing(String messageFromClient) {
        if (messageFromClient != null) {
            char firsChar = messageFromClient.toCharArray()[0];
            if ('#' == firsChar) {//пришла команда
                if ("#who".equalsIgnoreCase(messageFromClient)) {
                    // пока одна команда #who - кто есть на сервере
                    StringBuffer msg = new StringBuffer("Сейчас онлайн:\n");
                    clients.forEach((key, val) -> {
                        msg.append("@").append(val.getName()).append("\n");
                    });
                    sendMessage(msg.toString());
                } else {
                    sendMessage("Команда не распознана");
                }

            } else if ('@' == firsChar) { //пришло адресное или общее сообщение
                /* разбор пришедшего сообщения
                 *   протокол:
                 *   `Text_string` или `@All, Text_String` - сообщение для всех
                 *   `@Name, Text_String` - частное сообщение
                 */
                String[] splitMessage = messageFromClient.substring(1).split(",", 2);
                if (!splitMessage[0].equalsIgnoreCase("all")) {
                    String toClient = splitMessage[0];
                    String msg = splitMessage[1];
                    privateMessage(toClient, msg);
                }
            } else {// если не команда считаем что пришло общее сообщение
                broadcastMessage("@" + name + ": " + messageFromClient);
            }

        }
    }

    private void privateMessage(String toClient, String msg) {
        for (Map.Entry<String, ClientManager> entry : clients.entrySet()) {
            if (toClient.equals(entry.getValue().getName())) {
                entry.getValue().sendMessage(">>@" + name + ":  " + msg);
                break;
            }
        }
    }

    private void broadcastMessage(String message) {
        clients.forEach((key, val) -> {
            if (!socketClient.equals(key))
                val.sendMessage(message);
        });
    }

    public void sendMessage(String message) {
        try {
            bufferedWriter.write(message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            closeEverithing(socket, bufferedWriter, bufferedReader);
        }

    }

    private void closeEverithing(Socket socket, BufferedWriter bufferedWriter, BufferedReader bufferedReader) {
        removeClient();
        try {
            if (bufferedReader != null) bufferedReader.close();
            if (bufferedWriter != null) bufferedWriter.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void removeClient() {
        clients.remove(this.socketClient);
        System.out.println("Клиент " + this.name + " покинул чат");
        broadcastMessage("Клиент " + this.name + " покинул чат");
    }


    public String getName() {
        return name;
    }

    public String getSocketClient() {
        return socketClient;
    }

}
