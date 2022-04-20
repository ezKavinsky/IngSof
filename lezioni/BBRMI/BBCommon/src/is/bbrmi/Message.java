package BBRMI.BBCommon.src.is.bbrmi;

import java.io.Serializable;

public interface Message extends Serializable {

	void setBufferTime(long currentTimeMillis);

	long getBufferTime();

	void setData(Object s);

	Object getData();

}
