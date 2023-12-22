package loc.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class AppClient {
    public static void main(String[] args)
    {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите свое имя:");
            String name = scanner.nextLine();
            Socket socket = new Socket("127.0.0.1", 40000);
            Client client = new Client( socket, name);

            InetAddress inetAddress = socket.getInetAddress();
            System.out.println("InetAddress: "+inetAddress);
            String remoteIP = inetAddress.getHostAddress();
            System.out.println("Remote IP: "+remoteIP);
            System.out.println("LocalPort: "+socket.getLocalPort());

            client.listenForMessage();
            client.sendMessage();


        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}