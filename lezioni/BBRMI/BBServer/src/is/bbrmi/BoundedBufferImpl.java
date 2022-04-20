package BBRMI.BBServer.src.is.bbrmi;

import BBRMI.BBCommon.src.is.bbrmi.BBConsumerIF;
import BBRMI.BBCommon.src.is.bbrmi.BBProducerIF;
import BBRMI.BBCommon.src.is.bbrmi.Message;

public class BoundedBufferImpl implements BBConsumerIF, BBProducerIF {

	private final Message[] buffer;
	private final int n;
	private int in;
	private int out;
	private int count;

	public BoundedBufferImpl(int n) {
		this.n = n;
		buffer = new Message[n];
		in = 0;
		out = 0;
		count = 0;

	}

	@Override
	public void put(Message x) {
		buffer[in] = x;
		in = (in + 1) % n;
		count++;
		System.out.println("Buffering " + x + " ...");
		x.setBufferTime(System.currentTimeMillis());

	}

	@Override
	public Message get() {
		Message x = buffer[out];
		out = (out + 1) % n;
		count--;
		x.setBufferTime(System.currentTimeMillis() - x.getBufferTime());
		System.out.println("Unbuffering " + x + " ...");
		return x;

	}

	protected boolean empty() {
		return count == 0;
	}

	protected boolean full() {
		return count == n;
	}

}
