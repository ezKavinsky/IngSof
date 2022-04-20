package ChainOfResp.src.chain_of_responsability;

public class BranchManager extends LoanRequestHandler {
	//ConcreteHandler
	
	public void loanRequest(double amount) throws LoanRequestHandlerException {
		if (amount <= 80000)
			System.out.println("Accepted by BranchManager.");
		else
			forwardRequest(amount);
	}

}
