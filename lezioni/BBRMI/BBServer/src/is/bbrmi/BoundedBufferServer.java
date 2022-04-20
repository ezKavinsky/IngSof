package BBRMI.BBServer.src.is.bbrmi;

import BBRMI.BBCommon.src.is.bbrmi.BoundedBufferFactory;

import java.rmi.Naming;

public class BoundedBufferServer {
	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.out.println("no sec manager found! Installing it");
			System.setSecurityManager(new SecurityManager());
		}

		try {
			System.out.println("Costruzione factory ...");
			BoundedBufferFactory bbf =new BoundedBufferFactoryImpl();
			System.out.println("Pubblicazione factory ...");

			Naming.rebind("boundedbufferfactory", bbf);
			System.out.println("In attesa di clienti ...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// main

}
