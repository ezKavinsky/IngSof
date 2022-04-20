package BBRMI.BBClient.src.is.boundedbuffer_producer;

import BBRMI.BBCommon.src.is.bbrmi.BBProducerIF;
import BBRMI.BBCommon.src.is.bbrmi.BoundedBufferFactory;

import java.rmi.Naming;
import java.util.Scanner;

public class ProducerClient {
	public static void main(String[] args) {// TODO
		if (System.getSecurityManager() == null) {
			System.out.println("no sec manager found! Installing it");
	        System.setSecurityManager(new SecurityManager());
	    }

		//PCMessage prova= new PCMessage("ciao");
		// del server
		BoundedBufferFactory factory = null;
		BBProducerIF bb = null;
		try {
			String host="127.0.0.1";//inserire l'ip del server!!
			System.out.println("lookup");
			factory = (BoundedBufferFactory) Naming.lookup("rmi://"+host+"/boundedbufferfactory");

			System.out.println("server found");
			
			bb = factory.getProducerIF();
			
			Scanner sc = new Scanner(System.in);
			for (;;) {
				System.out.print("msg> ");
				String msg = sc.nextLine();
				bb.put(new PCMessage(msg));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}// ProducerClient
