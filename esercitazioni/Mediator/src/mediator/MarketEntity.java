package Mediator.src.mediator;

public abstract class MarketEntity {
	//Colleague

	MarketServiceOrganizer organizer;

	public MarketEntity(MarketServiceOrganizer organizer) {
		this.organizer = organizer;
	}

	/*
	 * utilizzato dai Colleagues per notificare al Mediator i propri cambiamenti di
	 * stato
	 */
	public void changed() {
		organizer.entityChanged(this);
	}

}
