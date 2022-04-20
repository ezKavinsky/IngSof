package ChainOfResp.src.chain_of_responsability;

public class Employee extends LoanRequestHandler {
	//ConcreteHandler

	public void loanRequest(double amount) throws LoanRequestHandlerException {
		if (amount <= 30000)
			System.out.println("Accepted by Employee.");
		else
			forwardRequest(amount);
	}

}
