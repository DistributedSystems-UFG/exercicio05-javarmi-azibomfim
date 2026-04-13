package example.hello;

import java.rmi.Naming;

public class Client {

    private Client() {}

    public static void main(String[] args) {

        System.out.println("Initiating client");

        // Forma para rodar local
        //String protocolo = "";
        //String host = protocolo + "//localhost/";

        // Strings para o AWS
        String protocolo = "rmi://";
        String host = protocolo + ((args.length < 1) ? null : args[0]) + "/";


        String nome1 = "MyHello";
        String nome2 = "MyBye";

        // Executando métodos de MyHelloImplem do Server

        try {
            Hello stub = (Hello) Naming.lookup(host + nome1);
            System.out.println("Server " + nome1 + " Achado!!!!");
            String response = stub.sayHello();
            System.out.println("Response: " + response);
            System.out.println(stub.soma(542, 754));
            System.out.println(stub.getFibo(12));
            System.out.println("Encerrado!");
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

        System.out.println("\n------------------------------------------\n");

        // Executando métodos de MyByeImplem do OutroServidor

        try {
            MyBye stub = (MyBye) Naming.lookup(host + nome2);
            System.out.println("Server " + nome2 + " Encontrado!!!!");
            String response = stub.sayBye();
            System.out.println("Response: " + response);
            System.out.println(stub.getPA(3, 4, 7));
            System.out.println("Encerrado!");

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

    }
}
