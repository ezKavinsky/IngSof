package Façade.src.facade;

public class FaçadeExample {

	public static void main(String[] args) {

		CarEngineFacade carEngineFacade = new CarEngineFacade();

		carEngineFacade.startEngine();
		carEngineFacade.stopEngine();

	}

}
