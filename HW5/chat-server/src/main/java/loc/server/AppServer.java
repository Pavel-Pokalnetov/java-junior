package loc.server;

import loc.server.Server;

public class AppServer {
    private static final int PORT = 1425;
    public static void main(String[] args) {
        Server server = new Server(PORT);
        server.start();
    }
}
