import java.util.*;
import java.net.*;
import java.io.*;


public class Exp2 {
    public static void main(String[] args) {
        try{
            String hostname="www.google.com";
            String Nexthopip=getNextHopIp(hostname);
            String MacAddress=getMacaddress(Nexthopip);
            System.out.println("nexthoppip: "+Nexthopip);
            System.out.println("macaddress:"+MacAddress);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }

    private static String getNextHopIp(String hostname) throws Exception{
        String command=System.getProperty("os.name").toLowerCase().contains("win")?"tracert":"traceroute";
        ProcessBuilder pb=new ProcessBuilder(command,hostname);
        Process process=pb.start();
        BufferedReader reader=new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while((line=reader.readLine())!=null){
            if(line.contains("ms")){
                String[] parts=line.split("\\s+");
                return parts[parts.length-1].replaceAll("[\\[\\]]","");
            }
        }
        return null;

    }

    private static String getMacaddress(String ip) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("arp", "-a");
        Process process = pb.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        
        while ((line = reader.readLine()) != null) {
            
            if (line.contains(ip+" ")) {
                // Split the line into parts based on whitespace
                String[] parts = line.trim().split("\\s+");
                
                
                // Check if the array has enough parts (at least 3: IP, MAC, and Type)
                if (parts.length >= 3) {
                    return parts[1];  // The second part contains the MAC address
                }
            }
        }
        return null;  // Return null if IP not found
    }
    
}


