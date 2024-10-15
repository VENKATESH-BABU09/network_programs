import java.util.*;
import java.net.*;
import java.io.*;

public class ServerPing {
    public static void main(String[] args) {
        try(ServerSocket ssr=new ServerSocket(12345);
        Socket sc=ssr.accept();
        ){
            System.out.println("client connected");
            System.out.println("server running on port 12345");

            PrintWriter writer=new PrintWriter(sc.getOutputStream(),true);
            writer.println("pingged from server");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
