package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatImpl extends UnicastRemoteObject implements ChatInt {

    public ChatImpl()throws RemoteException{

    }

    @Override
    public String mensagem(String mensagem){
        String aux = "Sua mensagem é: ";
        return aux.concat(mensagem);
    }
}
