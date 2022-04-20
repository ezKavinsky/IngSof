package Façade.src.facade.system;

public class Radiator {

	public void on() {
		System.out.println("Radiator switched on!");
	}

	public void off() {
		System.out.println("Radiator switched off!");
	}

	public void setSpeed(Integer speed) {
		System.out.println("Setting radiator speed to " + speed);
	}

}
