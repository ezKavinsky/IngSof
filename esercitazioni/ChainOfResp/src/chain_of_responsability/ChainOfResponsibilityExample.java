package ChainOfResp.src.chain_of_responsability;

public class ChainOfResponsibilityExample {

	public static void main(String[] args) throws LoanRequestHandlerException {

		Employee employee = new Employee();
		BranchManager branchManager = new BranchManager();
		AreaManager areaManager = new AreaManager();

		employee.setSuperiorRequestHandler(branchManager);
		branchManager.setSuperiorRequestHandler(areaManager);

		Customer customer = new Customer();
		int i = 500;
		while (i <= 100000) {
			System.out.println("Load request for € " + i);
			customer.requestLoan(employee, i);
			i += 500;
		}
		
	}
}
