package BBRMI.BBServer.src.is.bbrmi;

import BBRMI.BBCommon.src.is.bbrmi.BBConsumerIF;
import BBRMI.BBCommon.src.is.bbrmi.BBProducerIF;
import BBRMI.BBCommon.src.is.bbrmi.Message;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.Semaphore;

public class BoundedBufferSemaphoreImpl extends UnicastRemoteObject implements
		BBConsumerIF, BBProducerIF {

	/**
	 * 
	 */
	private static final long serialVersionUID = 457752108336455549L;
	private final Semaphore mutex = new Semaphore(1, true);
	private final Semaphore empty;
	private final Semaphore full;
	private final BoundedBufferImpl bb;

	public BoundedBufferSemaphoreImpl(int n) throws RemoteException {
		bb = new BoundedBufferImpl(n);
		empty = new Semaphore(n, true);
		full = new Semaphore(0, true);
	}

	@Override
	public void put(Message x) throws RemoteException {
		empty.acquireUninterruptibly();
		mutex.acquireUninterruptibly();
		bb.put(x);
		mutex.release();
		full.release();
	}// put

	@Override
	public Message get() throws RemoteException {
		full.acquireUninterruptibly();
		mutex.acquireUninterruptibly();
		Message x = bb.get();
		mutex.release();
		empty.release();
		return x;
	}// get

}
