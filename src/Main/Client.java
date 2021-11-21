package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Arrays;

import Command.Command;

public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 9090;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);

        ServerConnection serverConnection = new ServerConnection(socket);

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        new Thread(serverConnection).start();

        while (true) {
            System.out.println("> ");
            String command = keyboard.readLine();
            String[] values = {"set", "get", "append", "decr", "incr", "mget", "rpush", "rpop", "lpush", "lindex", "linsert",
                    "llen", "lrenge", "lset", "sadd", "scard", "sdiff", "sdiffstore", "sismember", "sunion"};
            boolean contains = Arrays.stream(values).anyMatch(command.split(" ")[0]::equals);
            if (contains) {
                Command.createCommand(command);
            } else if (command.equals("quit")) {
                break;
            }
        }
        socket.close();
        System.exit(0);
    }

}