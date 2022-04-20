package simpleRMI.simpleRMIclient.src.is.simpleRMI.client;

import simpleRMI.simpleRMIcommon.src.is.simpleRMI.Message;
import Polinomi.src.simpleRMIcommon.src.is.simpleRMI.MsgSource;

import java.rmi.Naming;
import java.util.Scanner;

public class SimpleMsgClient {

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.out.println("no sec manager found! Installing it");
            System.setSecurityManager(new SecurityManager());
        }

        MsgSource remoteObj = null;
        try (Scanner sc = new Scanner(System.in)){

            remoteObj = (MsgSource) Naming.lookup("rmi://160.97.24.119/msgSrc");
            for (;;) {
                System.out.print("Press Enter to receive ");
                String answer = sc.nextLine();
                Message msg = remoteObj.getMessage();
                System.out.println("msg=" + msg);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
