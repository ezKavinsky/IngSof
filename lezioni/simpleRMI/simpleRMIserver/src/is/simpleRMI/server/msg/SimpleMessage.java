package simpleRMI.simpleRMIserver.src.is.simpleRMI.server.msg;
import simpleRMI.simpleRMIcommon.src.is.simpleRMI.Message;

import java.io.Serializable;

public final class SimpleMessage implements Message, Serializable {
     private final String msg;

    public SimpleMessage(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "SimpleMessage{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
