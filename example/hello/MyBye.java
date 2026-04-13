package example.hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyBye extends Remote {
    String sayBye() throws RemoteException;
    String getPA(int n1, int r, int n) throws RemoteException;
}
