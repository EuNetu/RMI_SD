package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatInt extends Remote {
    public String mensagem(String mensagem)throws RemoteException;
}
