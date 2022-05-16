package rmi.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.ChatImpl;
import rmi.ChatInt;

public class Server {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(5000);
            ChatInt stub = new ChatImpl();
            registry.rebind("stub", stub);
            System.out.println("Server ligado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
