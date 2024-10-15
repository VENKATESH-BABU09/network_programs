 
import java.io.IOException; 
import java.net.InetSocketAddress; 
import java.net.Socket; 
import java.net.SocketAddress; 
 
public class PortScanner { 
 
    public static void main(String[] args) { 
        String host = "127.0.0.1";  
        int startPort = 1; 
        int endPort = 49151;  
 
        System.out.println("Scanning ports in use on " + host + ":"); 
 
        for (int port = startPort; port <= endPort; port++) { 
            if (isPortInUse(host, port)) { 
                System.out.println("Port " + port + " is in use."); 
            } 
        } 
    } 
 
    public static boolean isPortInUse(String host, int port) { 
        try (Socket socket = new Socket()) { 
            SocketAddress socketAddress = new InetSocketAddress(host, port); 
            socket.connect(socketAddress, 10000); // timeout after 1000ms 
            return true; 
        } catch (IOException e) { 
            return false; 
        } 
    } 
} 
 
