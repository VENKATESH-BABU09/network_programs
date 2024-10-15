import java.util.*;
import java.net.*;
import java.lang.*;
import java.io.*;


public class TimeClient {
    public static void main(String[] args){
        try{
            Socket sc=new Socket("localhost",1880);
            System.out.println("server connected on port 1880");
            DataOutputStream dot=new DataOutputStream(sc.getOutputStream());
            DataInputStream din=new DataInputStream(sc.getInputStream());
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            String cmsg="";
            String smsg="";
            // cmsg=reader.readLine();
            while(!cmsg.equals("stop")){
                System.out.println("enter the msg to send to server:");
                cmsg=reader.readLine();

                dot.writeUTF(cmsg);
                dot.flush();

                smsg=din.readUTF();
                System.out.println("server says: "+smsg);


            }
            sc.close();
            din.close();
            dot.close();


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
