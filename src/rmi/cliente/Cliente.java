package rmi.cliente;

import rmi.ChatInt;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            ChatInt remoteObject = (ChatInt) Naming.lookup("rmi://localhost:5000/stub");
            System.out.println("Server funcionando");

            new Thread(() -> {
                try {
                    String novaMessage = scanner.nextLine();
                    String ultimaMensagem = null;
                    while (true) {
                        String menssagem = remoteObject.mensagem(novaMessage);
                        if (menssagem != null && !menssagem.equals(ultimaMensagem)) {
                            ultimaMensagem = menssagem;
                            System.out.println(ultimaMensagem);
                        }
                        Thread.sleep(3000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
