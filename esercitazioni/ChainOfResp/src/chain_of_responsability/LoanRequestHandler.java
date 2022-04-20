package ChainOfResp.src.chain_of_responsability;

public abstract class LoanRequestHandler {
	//Handler 
	
	private LoanRequestHandler successor;

	public void setSuperiorRequestHandler(LoanRequestHandler superior) {
		this.successor = superior;
	}

	public void loanRequest(double amount) throws LoanRequestHandlerException {
		forwardRequest(amount);
	}

	protected void forwardRequest(double amount) throws LoanRequestHandlerException {
		if (successor != null)
			successor.loanRequest(amount);
		else
			throw new LoanRequestHandlerException();
	}

}
