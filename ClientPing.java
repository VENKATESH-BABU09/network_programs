import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.*;

public class ClientPing {
    public static void main(String[] args) {
        String host="127.0.0.1";
        int port=12345;

        try(Socket sc=new Socket(host,port)){
            System.out.println("server connected");

            BufferedReader reader=new BufferedReader(new InputStreamReader(sc.getInputStream()));
            String res=reader.readLine();

            System.out.println("received: "+res);

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
