import java.net.*;
import java.util.*;
public class Exp1{
    public static void main(String[] args) throws Exception{
        InetAddress LocalHost=InetAddress.getLocalHost();
        String hostname=LocalHost.getHostName();

        String HostAddress=LocalHost.getHostAddress();
        System.out.println("Host name:"+hostname);
        System.out.println("host Address"+HostAddress);

    }
}