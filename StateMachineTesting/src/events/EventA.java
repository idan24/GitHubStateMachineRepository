package events;

import framework.Event;

public class EventA extends Event {

	@Override
	public String getID() {
		return "A";
	}
	
	@Override
	public String getAdditionalData() {
		return "First event type";
	}
}
