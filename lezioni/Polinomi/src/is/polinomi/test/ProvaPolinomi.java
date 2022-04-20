package Polinomi.src.is.polinomi.test;

import Polinomi.src.is.polinomi.Monomio;
import Polinomi.src.is.polinomi.Polinomio;
import Polinomi.src.is.polinomi.bridge.PolinomioArrayFactory;
import Polinomi.src.is.polinomi.bridge.PolinomioConcreto;
import Polinomi.src.is.polinomi.bridge.PolinomioIntegrable;
import Polinomi.src.is.polinomi.prototype.PolinomioLL;
//import is.polinomi.factorymethod.PolinomioLL;

public class ProvaPolinomi {
	public static void main(String[] args) {
		//Polinomio p1 = new PolinomioArray(10);
		Polinomio p1 =new PolinomioConcreto();
		p1.add(new Monomio(2.0, 2));

		Polinomio p2 = new PolinomioLL();
		p2.add(new Monomio(4, 1));

		p2.add(new Monomio(3, 0));
		p2.add(new Monomio(1.5, 2));

		System.out.println("p1=" + p1);

		System.out.println(p1.getClass());

		System.out.println("p2=" + p2);
		System.out.println(p2.getClass());

		Polinomio prod = p1.mul(p2);
		System.out.println("prod=" + prod);
		System.out.println(prod.getClass());

		prod = p2.mul(p1);
		System.out.println("prod=" + prod);
		System.out.println(prod.getClass());


		PolinomioConcreto.setPolinomioImplFactory(new PolinomioArrayFactory());
		Polinomio p3=p1.add(p2);
		  
		System.out.println("p3="+p3);
		  
		System.out.println(p3.getClass());
		  
		System.out.println(((PolinomioLL)p2).clone());
		  
		 
		PolinomioIntegrable p4= new PolinomioIntegrable();
		p4.add(new Monomio(3, 0));
		p4.add(new Monomio(4, 1));
		System.out.println("p4="+p4); Polinomio p5=p4.integrate();
		System.out.println("p5="+p5);
		  
		Polinomio p6=p1.derive().mul(p4.integrate().integrate());
		System.out.println("p6="+p6);

	}
}
