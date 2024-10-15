import java.net.*;
import java.util.*;
import java.io.*;


public class ClientTcp {
    public static void main(String[] args) {
        try(Socket soc=new Socket("localhost",12345)){
            System.out.println("server connected and enter the file name you want to request from server:");
            Scanner sc=new Scanner(System.in);
            String reqfilename=sc.nextLine();
            PrintWriter writer=new PrintWriter(soc.getOutputStream(),true);
            writer.println(reqfilename);
            BufferedReader reader=new BufferedReader(new InputStreamReader(soc.getInputStream()));
            String serverres=reader.readLine();
            if((serverres.equals("File found"))){
                System.out.println("file found on server.enter the name to save the file:");
                String filesavename=sc.nextLine();
                InputStream ios=soc.getInputStream();
                FileOutputStream fs=new FileOutputStream(filesavename);
                BufferedOutputStream bos=new BufferedOutputStream(fs);
                byte[] buffer=new byte[4096];
                int bytesRead;
                while((bytesRead=ios.read(buffer))!=-1){
                    bos.write(buffer,0,bytesRead);
                }
                bos.close();
                System.out.println("file received and saved as "+filesavename);
            }
            else{
                System.out.println("requested file not found on server");
            }
            soc.close();



        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
        
}
    

