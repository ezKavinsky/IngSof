package BBRMI.BBCommon.src.is.bbrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BoundedBufferFactory extends Remote {

	BBConsumerIF getConsumerIF() throws RemoteException;

	BBProducerIF getProducerIF() throws RemoteException;
}
