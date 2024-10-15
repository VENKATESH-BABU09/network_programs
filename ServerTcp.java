import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.*;
import java.io.*;

public class ServerTcp {
    public static void main(String[] args) {
        try(ServerSocket serverSocket=new ServerSocket(12345)){
            Socket sc=serverSocket.accept();
            System.out.println("client connected");
            BufferedReader br=new BufferedReader(new InputStreamReader(sc.getInputStream()));
            String reqfile=br.readLine();
            File f=new File(reqfile);
            PrintWriter writer=new PrintWriter(sc.getOutputStream(),true);
            if(f.exists() && !f.isDirectory()){
                writer.println("File found");
                FileInputStream fis=new FileInputStream(f);
                BufferedInputStream bin=new BufferedInputStream(fis);
                OutputStream os=sc.getOutputStream();
                byte[] buffer=new byte[4096];
                int bytesRead;
                while((bytesRead=bin.read(buffer))!=-1){
                    os.write(buffer,0,bytesRead);
                }
                os.close();
                System.out.println("file successfully sent from server");


            }
            else{
                writer.println("File not found");
                System.out.println("file not fond on server");

            }

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
