package BBRMI.BBClient.src.is.boundedbuffer_producer;

import BBRMI.BBCommon.src.is.bbrmi.Message;

public class PCMessage implements Message {
	/**
	 * 
	 */
	private static final long serialVersionUID = 722553457785241370L;
	private long waitTime;
	String content;

	public PCMessage(String s) {
		content = s;
	}

	@Override
	public void setData(Object s) {
		content = (String) s;
	}

	@Override
	public Object getData() {
		return content;
	}

	@Override
	public void setBufferTime(long time) {
		waitTime = time;
	}

	@Override
	public long getBufferTime() {
		return waitTime;
	}

	@Override
	public String toString() {
		return content;
	}// toString
}// PCMessage

