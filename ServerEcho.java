import java.net.*;
import java.io.*;

public class ServerEcho {
    public static void main(String[] args) {
        try (
            ServerSocket ssc = new ServerSocket(1234);
            Socket sc = ssc.accept();
            DataInputStream din = new DataInputStream(sc.getInputStream());
            DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
        ) {
            System.out.println("Client connected");
            String res_msg;

            while (true) {
                try {
                    res_msg = din.readUTF();  // Read message from client

                    if (res_msg.equals("quit")) {
                        System.out.println("Client disconnected");
                        break;  // Exit the loop when 'quit' is received
                    }

                    System.out.println("Msg from client: " + res_msg);
                    dout.writeUTF(res_msg);  // Echo message back to client
                } catch (EOFException e) {
                    System.out.println("Client closed connection");
                    break;  // Exit the loop if the client disconnects unexpectedly
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
