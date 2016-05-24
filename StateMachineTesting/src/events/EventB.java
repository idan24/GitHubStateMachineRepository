package events;

import framework.Event;

public class EventB extends Event {
	
	@Override
	public String getID() {
		return "B";
	}
	
	@Override
	public String getAdditionalData() {
		return "Second event type";
	}
}
