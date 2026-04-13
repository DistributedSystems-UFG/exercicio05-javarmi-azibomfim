package example.hello;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class OutroServer {

    public OutroServer() {}

    public static void main(String args[]) {
        try {
            try {
                LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            } catch (RemoteException e) {
                System.out.println("Porta Registry já em uso!");
            }
            MyByeImplem obj = new MyByeImplem(5679);

            Naming.rebind("MyBye", obj);

            System.err.println("Outro servidor (implementa MyBye) esta pronto!");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}