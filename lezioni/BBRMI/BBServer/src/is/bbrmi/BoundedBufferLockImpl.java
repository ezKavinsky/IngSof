package BBRMI.BBServer.src.is.bbrmi;

import BBRMI.BBCommon.src.is.bbrmi.BBConsumerIF;
import BBRMI.BBCommon.src.is.bbrmi.BBProducerIF;
import BBRMI.BBCommon.src.is.bbrmi.Message;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBufferLockImpl extends UnicastRemoteObject implements BBConsumerIF, BBProducerIF {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8080205680017693497L;
	/**
	 * 
	 */
	private final BoundedBufferImpl bb;

	private final Lock lock = new ReentrantLock();
	private final Condition empty = lock.newCondition();
	private final Condition full = lock.newCondition();
	private final List<Thread> listaProduttori = new ArrayList<>();
	private final List<Thread> listaConsumatori = new ArrayList<>();

	private boolean produttoreDeveDormire() {
		return bb.full() || listaProduttori.get(0) != Thread.currentThread();
	}// produttoreDeveDormire

	private boolean consumatoreDeveDormire() {
		return bb.empty() || listaConsumatori.get(0) != Thread.currentThread();
	}// consumatoreDeveDormire

	public BoundedBufferLockImpl(int n) throws RemoteException {
		bb= new BoundedBufferImpl(n);
	}// costruttore

	@Override
	public void put(Message x) throws RemoteException {
		lock.lock();
		try {
			listaProduttori.add(Thread.currentThread());
			while (produttoreDeveDormire()) {
				full.awaitUninterruptibly();
			}
			listaProduttori.remove(0);
			bb.put(x);
			empty.signalAll();
		} finally {
			lock.unlock();
		}
	}// put

	@Override
	public Message get() throws RemoteException {
		Message x;
		lock.lock();
		try {
			listaConsumatori.add(Thread.currentThread());
			while (consumatoreDeveDormire()) {
				empty.awaitUninterruptibly();
			}
			listaConsumatori.remove(0);
			x = bb.get();
			full.signalAll();
		} finally {
			lock.unlock();
		}
		return x;
	}// get

}
