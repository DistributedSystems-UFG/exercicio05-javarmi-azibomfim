package example.hello;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class HelloImplem extends UnicastRemoteObject implements Hello {

    public HelloImplem(int port) throws RemoteException {
        super(port);
    }

    public String sayHello() throws RemoteException {
        return "Olá, como é bom responder com um olá! Então, olá!!!!!";
    }

    public String soma (int a, int b) throws RemoteException {
        return "Response from " + a + " + " + b + " = " + (a + b) + "\n";
    }

    public String getFibo (int m) throws RemoteException {
        if (m <= 0) {
            return "[]";
        }

        StringBuilder resultado = new StringBuilder();
        resultado.append("----- A sequência dos "+ m +" temos da serie de fibonacci -----\n");
        resultado.append("[");

        long a = 0;
        long b = 1;

        for (int i = 0; i < m; i++) {
            resultado.append(a);

            if (i < m - 1) {
                resultado.append(", ");
            }
            long proximo = a + b;
            a = b;
            b = proximo;
        }

        resultado.append("]");
        return resultado.toString();
    }
}
