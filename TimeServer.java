import java.net.*;
import java.io.*;
import java.util.*;

public class TimeServer {
    public static void main(String[] args) {
        try{
            ServerSocket ss=new ServerSocket(1880);
            System.out.println("server running on port 1880");
            System.out.println("waiting for client");
            Socket s=ss.accept();
            System.out.println("client connected");
            DataInputStream din=new DataInputStream(s.getInputStream());
            DataOutputStream dot=new DataOutputStream(s.getOutputStream());
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            String c_msg="";
            String s_msg="";
            while(!c_msg.equals("stop")){
                c_msg=din.readUTF();
                System.out.println("client says:"+c_msg);

                System.out.println("enter the msg you want to sent to the client:");
                s_msg=reader.readLine();
                String response=s_msg+"[ the sever msg at "+new Date()+" ]";

                dot.writeUTF(response);
                dot.flush();
            }
            din.close();
            dot.close();

            s.close();
            ss.close();



        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
