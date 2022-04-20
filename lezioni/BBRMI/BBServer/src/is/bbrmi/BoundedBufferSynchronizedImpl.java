package BBRMI.BBServer.src.is.bbrmi;

import BBRMI.BBCommon.src.is.bbrmi.BBConsumerIF;
import BBRMI.BBCommon.src.is.bbrmi.BBProducerIF;
import BBRMI.BBCommon.src.is.bbrmi.Message;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class BoundedBufferSynchronizedImpl extends UnicastRemoteObject
		implements BBConsumerIF, BBProducerIF {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1049720587089196972L;
	private final List<Thread> listaProduttori = new ArrayList<>();
	private final List<Thread> listaConsumatori = new ArrayList<>();
	private final BoundedBufferImpl bb;

	private boolean produttoreDeveDormire() {
		return bb.full() || listaProduttori.get(0) != Thread.currentThread();
	}// produttoreDeveDormire

	private boolean consumatoreDeveDormire() {
		return bb.empty() || listaConsumatori.get(0) != Thread.currentThread();
	}// consumatoreDeveDormire

	public BoundedBufferSynchronizedImpl(int n) throws RemoteException {
		bb = new BoundedBufferImpl(n);
	}// costruttore

	public synchronized void put(Message x) throws RemoteException {
		listaProduttori.add(Thread.currentThread());
		while (produttoreDeveDormire()) {
			try {
				wait();
			} catch (InterruptedException e) {
				listaProduttori.remove(Thread.currentThread());
				throw new RemoteException("Server Thread interrupted", e);
			}
		}
		listaProduttori.remove(0);
		bb.put(x);
		notifyAll();
	}// put

	public synchronized Message get() throws RemoteException {
		listaConsumatori.add(Thread.currentThread());
		while (this.consumatoreDeveDormire()) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		listaConsumatori.remove(0);
		Message x = bb.get();
		notifyAll();
		return x;
	}// get

}
