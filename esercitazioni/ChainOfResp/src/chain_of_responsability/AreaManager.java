package ChainOfResp.src.chain_of_responsability;

public class AreaManager extends LoanRequestHandler {
	// ConcreteHandler

	public void loanRequest(double amount) throws LoanRequestHandlerException {
		//if (amount < 90000)
			System.out.println("Accepted by AreaManager.");
		//else forwardRequest(amount);
	}

}
