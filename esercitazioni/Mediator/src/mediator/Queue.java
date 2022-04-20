package Mediator.src.mediator;

public class Queue extends MarketEntity {
	//ConcreteColleague

	private int size;

	public Queue(MarketServiceOrganizer organizer) {
		super(organizer);
	}

	public void enqueue() {
		size++;
		changed();
	}

	public void dequeue() {
		if (size > 0)
			size--;
	}

	public int getSize() {
		return size;

	}
}
