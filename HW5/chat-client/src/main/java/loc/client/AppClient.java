package loc.client;

import loc.client.exceptions.AppExeption;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class AppClient {
    private static String serverIp = "127.0.0.1";
    private static int port = 1425;

    public static void main(String[] args)
    {
        System.out.println("Client start...");
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите свое имя:");
            String name = scanner.nextLine();
            Client client = new Client(serverIp,port,name);
            Socket socket = client.connect();
            if(socket==null){
                throw  new AppExeption("Нет соединения с сервером");
            }
            InetAddress inetAddress = socket.getInetAddress();
            System.out.println("InetAddress: "+inetAddress);
            String remoteIP = inetAddress.getHostAddress();
            System.out.println("Remote IP: "+remoteIP);
            System.out.println("LocalPort: "+socket.getLocalPort());

            client.listenForMessage();
            client.sendMessage();

        } catch (AppExeption e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (InterruptedException e) {
            System.out.println("Ручное прерывание");
            System.exit(1);
        }catch (IOException e){
            System.out.println("Ошибка ввода вывода");
            e.printStackTrace();
        }

    }
}