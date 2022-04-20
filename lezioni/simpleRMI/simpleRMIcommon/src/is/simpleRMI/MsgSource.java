package simpleRMI.simpleRMIcommon.src.is.simpleRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MsgSource extends Remote {
    Message getMessage() throws RemoteException;
}