package example.hello;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class MyByeImplem extends UnicastRemoteObject implements MyBye {

    public MyByeImplem(int port) throws RemoteException {
        super(port);
    }

    public String sayBye() throws RemoteException {
        return "\n      c~~p ,---------.\n" +
                " ,---'oo  )           \\\n" +
                "( O O                  )/\n" +
                " `=^='                 /\n" +
                "       \\    ,     .   /\n" +
                "       \\\\  |-----'|  /\n" +
                "       ||__|    |_|__|\nATÉ MEU REI!\n";
    }

    public String getPA(int n1, int r, int n) throws RemoteException{

        if (n <= 0) {
            return "[]";
        }

        StringBuilder resultado = new StringBuilder();
        resultado.append("----- PA de inicio " + n1 + ", razao "+ r +" e com "+ n + " termos -----\n");
        resultado.append("[");

        for (int i = 0; i < n; i++) {

            int termoAtual = n1 + (i * r);
            resultado.append(termoAtual);

            if (i < n - 1) {
                resultado.append(", ");
            }
        }

        resultado.append("]");
        return resultado.toString();
    }
}
