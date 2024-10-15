import java.net.*;
import java.io.*;
import java.util.*;

public class ClientEcho {
    //client program for echo client
    public static void main(String[] args) {
        try(
            Socket sc=new Socket("localhost",1234);
            DataInputStream din=new DataInputStream(sc.getInputStream());
            DataOutputStream dout=new DataOutputStream(sc.getOutputStream());
            Scanner n=new Scanner(System.in);
        ){
            System.out.println("client connected to server");
            String send_msg;

            
            while(true){
                System.out.println("enter the msg to echo:");
                send_msg=n.nextLine();
                if(send_msg.equals("quit")){
                    System.out.println("disconnected from server");
                    break;
                }
                else{
                    dout.writeUTF(send_msg);
                    System.out.println("echoed from server:"+din.readUTF());
                }

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
            

}
