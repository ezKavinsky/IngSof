package Mediator.src.mediator;

public class Cashier extends MarketEntity {
	//CocnreteColleague

	private boolean isFree;

	public Cashier(MarketServiceOrganizer organizer) {
		super(organizer);
		isFree = true;
	}

	public void initService(Queue q) {
		if (isFree) {
			q.dequeue();
		}
	}

	public void endService() {
		isFree = true;
		changed();
	}

	public boolean isFree() {
		return isFree;
	}

	public void takeClient(Queue queue) {
		isFree=false;
		queue.dequeue();

	}
}
