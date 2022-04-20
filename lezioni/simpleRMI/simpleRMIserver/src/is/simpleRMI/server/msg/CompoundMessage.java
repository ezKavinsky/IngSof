package simpleRMI.simpleRMIserver.src.is.simpleRMI.server.msg;

import simpleRMI.simpleRMIcommon.src.is.simpleRMI.Message;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public final class CompoundMessage implements Message, Serializable {
    private final List<Message> msgList= new LinkedList<>();

    @Override
    public String toString() {
        return "CompoundMessage{" +
                "msgList=" + msgList +
                '}';
    }

    public void add(String msg){
        msgList.add(new SimpleMessage(msg));

    }


}
