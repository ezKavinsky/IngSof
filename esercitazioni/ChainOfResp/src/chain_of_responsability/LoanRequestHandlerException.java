package ChainOfResp.src.chain_of_responsability;

public class LoanRequestHandlerException extends Exception {
	public LoanRequestHandlerException() {
		super("No handler found to forward the request.");
	}
}
