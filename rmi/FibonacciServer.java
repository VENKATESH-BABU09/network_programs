// import java.rmi.registry.LocateRegistry;
// import java.rmi.registry.Registry;
import java.rmi.registry.*;
public class FibonacciServer{
    public static void main(String[] args) {
        try {
            FibonacciImpl fibonacci = new FibonacciImpl();
            Registry registry = LocateRegistry.createRegistry(1100);
            registry.rebind("FibonacciService", fibonacci);
            System.out.println("Fibonacci RMI Server is ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
