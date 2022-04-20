package ChainOfResp.src.chain_of_responsability;

public class Customer {
	//Client
	
	public void requestLoan(LoanRequestHandler loanRequestHandler, double amount) throws LoanRequestHandlerException {

		loanRequestHandler.loanRequest(amount);

	}

}
