package events;

import framework.Event;

public class EventC extends Event {
	
	@Override
	public String getID() {
		return "C";
	}
	
	@Override
	public String getAdditionalData() {
		return "Third event type";
	}
}
