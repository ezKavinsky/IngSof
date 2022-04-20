package BBRMI.BBServer.src.is.bbrmi;

import BBRMI.BBCommon.src.is.bbrmi.BBConsumerIF;
import BBRMI.BBCommon.src.is.bbrmi.BBProducerIF;
import BBRMI.BBCommon.src.is.bbrmi.BoundedBufferFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Properties;

public class BoundedBufferFactoryImpl extends UnicastRemoteObject implements
		BoundedBufferFactory {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2537745689373880036L;
	private Object bb;
	
	public BoundedBufferFactoryImpl() throws RemoteException {

	}

	@Override
	public BBConsumerIF getConsumerIF() throws RemoteException {
		return (BBConsumerIF)getBuffer();
	}

	@Override
	public BBProducerIF getProducerIF() throws RemoteException {
		return (BBProducerIF)getBuffer();
	}

	private synchronized Object  getBuffer() {
		if (bb != null)
			return bb;
		Properties p = new Properties();
		int n = 5;// dimensione di default
		try {//TODO 
			FileInputStream in = new FileInputStream(
					"buffer.properties");
			p.load(in);
			String size = p.getProperty("BufferSize");
			n = Integer.parseInt(size);
			System.out.println("buffer size=" + n);
			String concType = p.getProperty("ConcurrencyMethod");
			if (concType.equalsIgnoreCase("Semaphore")) {
				System.out.println("Semaphore");
				bb = new BoundedBufferSemaphoreImpl(n);
			} else if (concType.equalsIgnoreCase("Lock")) {
				System.out.println("Lock/Condition");
				bb = new BoundedBufferLockImpl(n);
			} else {// monitor nativo di default
				System.out.println("Java Native Monitor");
				bb = new BoundedBufferSynchronizedImpl(n);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Java Native Monitor");
			try{
				bb = new BoundedBufferSynchronizedImpl(n);
			} catch (RemoteException re) {
				e.printStackTrace();	
				System.out.println("Cannot create any buffer ...");
			}
		}

		return bb;

	}
}
