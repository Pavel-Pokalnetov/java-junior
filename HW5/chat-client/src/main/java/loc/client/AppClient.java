package loc.client;

import loc.client.exceptions.AppExeption;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;

public class AppClient {
    private static String serverIp = "127.0.0.1";
    private static int port = 1425;

    public static void main(String[] args) {
        System.out.println("Client start...");
        try {
            //добавляем имя из аргументов запуска
            String name;
            if (args.length == 0) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Введите свое имя:");
                name = scanner.nextLine();
            } else {
                name = args[0];
            }
//            String name = String.valueOf(System.currentTimeMillis());
            Client client = new Client(serverIp, port, name);
            Socket socket = client.connect();
            if (socket == null) {
                throw new AppExeption("Нет соединения с сервером");
            }
            InetAddress inetAddress = socket.getInetAddress();
            System.out.println("InetAddress: " + inetAddress.toString().split("/")[1]);
            String remoteIP = inetAddress.getHostAddress();
            System.out.println("Remote IP: " + remoteIP);
            System.out.println("LocalPort: " + socket.getLocalPort());
            System.out.println("--------------------------------------");
            client.listenForMessage();
            client.sendMessage();

        } catch (AppExeption e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (InterruptedException e) {
            System.out.println("Ручное прерывание");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Ошибка ввода вывода");
            e.printStackTrace();
        }

    }
}